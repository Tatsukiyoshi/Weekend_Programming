//====================
// DataServiceクラス
//  ・コンポーネントからの要求を集中処理
//　・アプリの状態管理
//====================

import {Injectable} from '@angular/core';
import {Alarm} from '../class/alarm.class';
import {State} from '../class/state.class';
import {MatSnackBar} from '@angular/material';
import {PushService} from './push.service';
import {Title} from '@angular/platform-browser';
import {PermissionService} from './permission.service';
import {Catch} from '../class/log.class';
import {Router} from '@angular/router';

@Injectable()
export class DataService {

  //アプリの状態
  state: State;
  bgMessage = ""; //背景メッセージ

  constructor(
    private snackBar: MatSnackBar,
    private permissionService: PermissionService,
    private pushService: PushService,
    private title: Title,
    private router: Router
  ) {
    this.init();
  }

  //DataServiceの初期化
  @Catch()
  init() {
    this.state = new State();
  }

  //状態オブジェクトのプロパティ管理
  get alarmList(): Alarm[] {
    return this.state.alarmList;
  }

  @Catch()
  set alarmList(alarmList: Alarm[]) {
    this.state.alarmList = alarmList;
  }

  get theme(): string {
    return this.state.theme;
  }

  @Catch()
  set theme(name: string) {
    this.state.theme = name;
    // this.state.changeTheme(name);
  }

  get isEnablePush(): boolean {
    return this.state.isEnablePush;
  }

  @Catch()
  set isEnablePush(isPush: boolean) {
    this.state.isEnablePush = isPush;
  }

  //ブラウザが閉じる前に状態を保存
  @Catch()
  onBeforeUnload() {
    this.state.onBeforeUnload();
  }

  //タイトルの設定
  @Catch()
  setTitle(str: string) {
    this.title.setTitle(str);
  }

  //ローカルアラームの登録
  @Catch()
  addLocalAlarm(alarm: Alarm): boolean {
    let rest = alarm.alarmTimestamp - Date.now();
    if (rest < 5) {
      alert("アラームまで5秒以下のため登録できませんでした””””");
      return false;
    }
    //ローカルアラーム一覧登録とタイマー開始
    this.state.addLocalAlarm(alarm, this.timeup);
    return true;
  }

  @Catch()
  async getPermission(): Promise<boolean> {

    //通知ダイアログ表示の許可
    let state = await this.permissionService.isGranted();
    console.log("許可状況: " + state);
    if (state == "granted") {
      return true;
    }
    if (state == "default") {
      //背景を暗くして通知許可のメッセージに見落としを避ける
      this.bgMessage =
        `[許可]をクリックすると、
       このページを閉じてもアラートを表示します`;
      let result = await this.permissionService.confirm();
      this.bgMessage = "";

      console.log("許可結果" + result);
      return result;
    }
  }


  //Push通知アラームの登録
  @Catch()
  addPushAlarm(alarm: Alarm) {

    this.isReadySW()
    .then(ret=>{if(ret.success){
      return this.pushService.pushReq(alarm)
    }else{
      return Promise.reject("Service Workerの準備ができていません")
    }})
    .then(
      ret=> {if(ret){
        //アラームにPush通知予約済みの設定
        this.alarmList.forEach(item => {
          if (item.id == alarm.id) {
            item.isPush = true;
            console.log("Push通知アラーム登録成功");
          }
        });
      } else{
        return Promise.reject("アプリサーバーへアラーム登録失敗");
      }
      }).catch(
        error=>alert(error)
    )
  }

  //設定時刻になったアラームをスナックバーで出力
  timeup = (alarm: Alarm) => {
    let msg = alarm.getTimeString() + "(" + alarm.title + ")";
    this.state.deleteAlarm(alarm);
    this.openSnackBar(msg);
  };

  //スナックバー表示
  @Catch()
  openSnackBar(msg: string) {
    this.snackBar.open(msg, "✖閉じる",
      {
        verticalPosition: "top",
        horizontalPosition: "left"
      });
  }


  //アラーム一覧の整理（設定時刻経過済みのアラームを削除）
  @Catch()
  cleanupAlarmList(): Alarm[] {
    return this.state.cleanupAlarmList();
  }

  //アラーム削除
  @Catch()
  async delete(index: number) {
    //削除対象をコピー
    let tmp = Object.assign({}, this.alarmList[index]);
    //ローカルアラーム削除
    this.state.deleteLocalAlarm(index);
    //Push通知アラーム削除
    if (tmp.isPush) {
      if (tmp.alarmTimestamp - Date.now() < 30) {
        alert(
          "アラーム時刻まで30秒以内は削除してもPush通知が届きます");
        return;
      }
      let ret: any = await this.pushService.cancelReq(tmp);
      if (!ret) {
        throw new Error("Push通知のキャンセル失敗");
      }
    }
  }

  //メニューでリセット選択（アプリの初期化）
  @Catch()
  async initApp() {
    //Service Workerのリセット
    await this.resetSW();
    //状態復元データ削除
    delete localStorage.state;
    //状態データ初期化(状態のリストアをしない)
    this.state = new State(false);
    //タイマー名の累積カウンタをリセット
    localStorage.setItem("count", "0");
    //トップページの表示
    location.reload(true);// = "/";

    this.router.navigate(["/"]);
    //Service Worker登録
    // this.regSW();
  }

  //Service Workerの状況確認
  @Catch()
  private async isReadySW():
    Promise<{success:boolean, data:any}> {
    //Service Worker APIのサポート確認
    let regs;
    if ('serviceWorker' in navigator) {
      regs = await navigator.serviceWorker.getRegistrations();
      console.log("Service Worker登録件数:" + regs.length);
      let cacheNames = await caches.keys();
      let swCaheNames = cacheNames.filter(name => (name.indexOf("ngsw:") > -1));
      console.log("Service Workerキャッシュ件数:" + swCaheNames.length);
      return {success: true, data: {regs, swCaheNames}};
    } else {
      throw  new Error("ServiceWorkerが利用できません");
    }
  }

  //Service Workerのリセット
  @Catch()
  private async resetSW() {
    let ret = await this.isReadySW(); //Service Worker
    if (ret.success) {
      //登録済みのService Workerを1件づつ登録解除
      for (let registration of ret.data.regs) {
        let scope = registration.scope;
        let ret = await registration.unregister();
        console.log("Service Worker登録解除"
          + scope + "," + ret);
      }
      //ngsw:を名前に含むものを削除
      for (let cacheName of ret.data.swCaheNames) {
        let ret = await caches.delete(cacheName);
        console.log("削除したキャッシュ" + cacheName + "," + ret);
      }
    } else {
      throw new Error("ServiceWorkerが利用できません");
    }
    //Service Worker登録
    // await navigator.serviceWorker.register("/ngsw-worker.js");
  }

}
