//====================
// リスト画面コンポーネント
//====================

import {Component, OnDestroy, OnInit} from "@angular/core";
import {DataService} from "../../service/data.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Alarm} from "../../class/alarm.class";
import {Catch} from '../../class/log.class';

@Component({
  selector: "app-list",
  templateUrl: "./list.component.html",
  styleUrls: ["../../common.css", "./list.component.css"]
})
export class ListComponent implements OnInit, OnDestroy {

  tmpAlarm: Alarm;     //設定途中のアラーム
  alarmList: Alarm[];  //実行中のアラーム
  refreshTimer;

  constructor(
    public dataService: DataService,
    private activatedRoute: ActivatedRoute,
    private router: Router,
  ) {
    //短い記述で呼び出すための参照を代入
    this.alarmList = dataService.alarmList;
    //新規Alarmオブジェクトを生成
    this.tmpAlarm = new Alarm();
  }

  @Catch()
  //ページロード時の処理
  ngOnInit() {
    this.dataService.setTitle("アラーム一覧"); //タイトル更新
    this.refresh(); //アラーム一覧の更新
  }

  @Catch()
  //アラーム一覧の更新（設定時刻を過ぎたものを削除)
  refresh() {
    this.dataService.cleanupAlarmList();//アラーム一覧の更新を依頼
    this.refreshTimer = setTimeout(() => {
      this.refresh()}, 30000);//30秒間隔で更新
  }

  @Catch()
  //ページ終了時の処理
  ngOnDestroy() {
    clearTimeout(this.refreshTimer);//30秒間隔タイマー停止
  }

  @Catch()
  //次ページへ移動
  async next() {
    this.tmpAlarm.updateAlarmNameCounter();//アラーム名取得
    await this.router.navigate(
      ["/edit"], //移動先URLパス
      {queryParams: this.tmpAlarm});//アラームデータ埋め込み
  }

  //アラーム一覧でゴミ箱クリック
  @Catch()
  delete(index: number) {
    this.dataService.delete(index);//アラーム削除を依頼
  }

}
