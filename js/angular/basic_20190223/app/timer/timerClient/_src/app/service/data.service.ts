// ====================
// DataServiceクラス
//  ・コンポーネントからの要求を集中処理
// 　・アプリの状態管理
// ====================

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

       private stateObj;
       
        constructor(
        private snackBar: MatSnackBar,
        private permissionService: PermissionService,
        private pushService: PushService,
        private title: Title,
        private router: Router,
    ) {
        this.stateObj = new State();
    }

    // 状態オブジェクトのプロパティ管理
    get alarmList(): Alarm[] {
        return this.stateObj.alarmList;
    }

    @Catch()
    set alarmList(alarmList: Alarm[]) {
        this.stateObj.alarmList = alarmList;
    }

    get theme(): string {
        return this.stateObj.theme;
    }

    @Catch()
    set theme(name: string) {
        this.stateObj.theme = name;
        this.stateObj.changeTheme(name);
    }

    get isEnablePush(): boolean {
        return this.stateObj.isEnablePush;
    }

    @Catch()
    set isEnablePush(isPush: boolean) {
        this.stateObj.isEnablePush = isPush;
    }

    // アプリの状態
    stateObj: State;
    bgMessage = ''; // 背景メッセージ


// メニューでリセット選択（アプリの初期化）
    @Catch()
    init() {
        this.stateObj = new State();
    }

    // ブラウザが閉じる前に状態を保存
    @Catch()
    onBeforeUnload() {
        this.stateObj.onBeforeUnload();
    }

    // タイトルの設定
    @Catch()
    setTitle(str: string) {
        this.title.setTitle(str);
    }

    // ローカルアラームの登録
    @Catch()
    addLocalAlarm(alarm: Alarm): boolean {
        const rest = alarm.alarmTimestamp - Date.now();
        if (rest < 5) {
            alert('アラームまで5秒以下のため登録できませんでした””””');
            return false;
        }
        // ローカルアラーム一覧登録とタイマー開始
        this.stateObj.addLocalAlarm(alarm, this.timeup);
        return true;
    }

    @Catch()
    async getPermission(): Promise<boolean> {

        // 通知ダイアログ表示の許可
        const state = await this.permissionService.isGranted();
        console.log('許可状況: ' + state);
        switch (state) {
            case 'granted':
                return true;
            case 'default':
                break;
            default:
                return false;
        }

        // 背景を暗くして通知許可のメッセージに見落としを避ける
        this.bgMessage =
            `[許可]をクリックすると、
       このページを閉じてもアラートを表示します`;
        const result = await this.permissionService.confirm();
        this.bgMessage = '';
        console.log('許可結果' + result);
        return result;
    }


// Push通知アラームの登録
    @Catch()
    addPushAlarm(alarm: Alarm) {
        this.isReadySW()
            .then((ret: any) => {
                if (ret.success) {
                    return this.pushService.pushReq(alarm);
                } else {
                    return Promise.reject('Service Workerの準備ができていません');
                }
            })
            .then(
                ret => {
                    if (ret) {
                        // アラームにPush通知予約済みの設定
                        this.alarmList.forEach(item => {
                            if (item.id === alarm.id) {
                                item.isPush = true;
                                console.log('Push通知アラーム登録成功');
                            }
                        });
                    } else {
                        return Promise.reject('アプリサーバーへアラーム登録失敗');
                    }
                }).catch(
            error => alert(error)
        );
    }

// 設定時刻になったアラームをスナックバーで出力
    @Catch()
    timeup (alarm: Alarm) {
        const msg = alarm.getTimeString() + '(' + alarm.title + ')';
        this.stateObj.deleteAlarm(alarm);
        this.openSnackBar(msg);
    }

// スナックバー表示
    @Catch()
    openSnackBar(msg: string) {
        this.snackBar.open(msg, '✖閉じる',
            {
                verticalPosition: 'top',
                horizontalPosition: 'left'
            });
    }


// アラーム一覧の整理（設定時刻経過済みのアラームを削除）
    @Catch()
    cleanupAlarmList() {
        return this.stateObj.cleanupAlarmList();
    }

// アラーム削除
    @Catch()
    async delete(index: number) {
        // 削除対象をコピー
        const tmp = Object.assign({}, this.alarmList[index]);
        // ローカルアラーム削除
        this.stateObj.deleteLocalAlarm(index);
        // Push通知アラーム削除
        if (tmp.isPush) {
            if (tmp.alarmTimestamp - Date.now() < 30) {
                alert(
                    'アラーム時刻まで30秒以内は削除してもPush通知が届きます');
                return;
            }
            const ret: any = await this.pushService.cancelReq(tmp);
            if (!ret) {
                throw new Error('Push通知のキャンセル失敗');
            }
        }
    }

    async initApp(isClearStorage= true) {
        // Service Workerのリセット
        await this.resetSW();
        if (isClearStorage) {
        // 状態復元データ削除
        delete localStorage.state;
        // 状態データ初期化(状態のリストアをしない)
        this.stateObj = new State(false);
        // タイマー名の累積カウンタをリセット
        localStorage.setItem('count', '0');
        }
        // トップページの表示
        location.reload(true); // = "/";

        this.router.navigate(['/']);
        // Service Worker登録
        // this.regSW();
    }

// Service Workerの状況確認
    @Catch()
    private async isReadySW() {
        // Service Worker APIのサポート確認
        let regs;
        if ('serviceWorker' in navigator) {
            regs = await navigator.serviceWorker.getRegistrations();
            console.log('Service Worker登録件数:' + regs.length);
            const cacheNames = await caches.keys();
            const swCaheNames = cacheNames.filter(name => (name.indexOf('ngsw:') > -1));
            console.log('Service Workerキャッシュ件数:' + swCaheNames.length);
            return {success: true, data: {regs, swCaheNames}};
        } else {
            return new Error('ServiceWorkerが利用できません');
        }

    }

// Service Workerのリセット
    @Catch()
    private async resetSW() {
        let ret: any = await this.isReadySW(); // Service Worker
        if (ret.success) {
            // 登録済みのService Workerを1件づつ登録解除
            for (const registration of ret.data.regs) {
                const scope = registration.scope;
                ret = await registration.unregister();
                console.log('Service Worker登録解除'
                    + scope + ',' + ret);
            }
            // ngsw:を名前に含むものを削除
            if ((ret.data) && (ret.data.swCaheNames)) {
                for (const cacheName of ret.data.swCaheNames) {
                    ret = await caches.delete(cacheName);
                    console.log('削除したキャッシュ' + cacheName + ',' + ret);
                }
            } else {
                throw new Error('ServiceWorkerが利用できません');
            }
        }
        // Service Worker登録
        // await navigator.serviceWorker.register("/ngsw-worker.js");
    }

}
