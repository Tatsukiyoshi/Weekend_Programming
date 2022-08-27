//====================
// アラームの設定
//====================

import {Component, OnInit,} from '@angular/core';
import {ActivatedRoute, Router} from '@angular/router';
import {Alarm} from '../../class/alarm.class';
import {DataService} from '../../service/data.service';
import * as queryString from "query-string";
import {Catch} from '../../class/log.class';

@Component({
  selector: 'app-set',
  templateUrl: './set.component.html',
  styleUrls: ['../../common.css', './set.component.css']
})
export class SetComponent implements OnInit {

  tmpAlarm: Alarm;　 //設定途中のアラーム
  oneClickLink = "";//1-clickリンク

  constructor(
    public dataService: DataService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
  };

  //ページロード時
  @Catch()
  async ngOnInit() {
    //Query Stringからアラームデータ復元
    let dataObj = this.activatedRoute.snapshot.queryParams;
    //URL埋め込みデータを元にアラームオブジェクトを復元
    this.tmpAlarm = (new Alarm(dataObj)).update();
    //ページのタイトルを更新
    this.dataService.setTitle(this.tmpAlarm.title);

    //1-clickリンクから呼び出された場合
    if (dataObj.action == "oneclick") {
      //テーマを更新
      this.dataService.theme = dataObj.theme;
      //アラーム一覧へ画面遷移
      await this.next();
    }
  }


  //1-clickリンクの生成
  @Catch()
  createOneClickLink() {
    this.oneClickLink =
      location.protocol + "//" +
      location.host + "/set?" +
      queryString.stringify(//外部ライブラリでObject->QueryString変換
        Object.assign(
          this.tmpAlarm,//現在設定中のアラーム
          {action: "oneclick"},//urlにaction=oneclickで判定
          {theme: this.dataService.theme}//現在のテーマ
        )
      );
  }


  //生成した1-clickリンクをクリップボードへコピー
  @Catch()
  copyLink(hiddenText) {
    this.createOneClickLink(); //リンク文字列の取得
    hiddenText.value = this.oneClickLink;//隠し入力欄へ値を設定
    hiddenText.focus();//隠し入力欄へフォーカスをあてる
    hiddenText.select();//隠し入力欄を選択
    document.execCommand("copy");//隠し入力欄からコピー
    this.dataService.openSnackBar("クリップボードにコピーしました")
  }


  //次ボタンクリック
  @Catch()
  async next() {
    this.tmpAlarm.isPush = false;//Push通知アラームアイコン表示オフ
    //ロ－カルアラームの登録
    let ret = this.dataService.addLocalAlarm(this.tmpAlarm);
    //アラーム登録に失敗した時は編集画面へ戻る
    if (!ret) {
      await this.back();
      return;
    }

    //Push通知アラームの登録
    if (this.dataService.isEnablePush) {
      //Push通知アラーム登録はバックグラウンド処理として扱う
      this.dataService.addPushAlarm(this.tmpAlarm);
    }
    //リスト画面へ遷移
    await this.router.navigate(["/list"]);
  }

  
  //戻るボタンクリック
  @Catch()
  async back() {
    //URLにアラーム情報を埋め込み編集画面へ遷移
    await this.router.navigate(
      ["/edit"],
      {queryParams: this.tmpAlarm}
    );
  }

}
