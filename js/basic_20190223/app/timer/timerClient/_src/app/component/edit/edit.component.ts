//====================
// 編集画面コンポーネント
//====================

import {Component, OnInit} from "@angular/core";
import {DataService} from "../../service/data.service";
import {ActivatedRoute, Router} from "@angular/router";
import {Alarm} from "../../class/alarm.class";
import {Catch} from '../../class/log.class';

@Component({
  selector: "app-edit",
  templateUrl: "./edit.component.html",
  styleUrls: ["../../common.css", "./edit.component.css"]
})
export class EditComponent implements OnInit {

  tmpAlarm: Alarm; //設定途中のアラーム

  constructor(
    public dataService: DataService,
    private activatedRoute: ActivatedRoute,
    private router: Router) {
  };

  //ページロード時
  @Catch()
  ngOnInit() {
    //Query Stringからアラームデータ復元
    let dataObj = this.activatedRoute.snapshot.queryParams;
    //URL埋め込みデータを元にアラームオブジェクトを復元
    this.tmpAlarm = (new Alarm(dataObj)).update();
    //ページのタイトルを更新
    this.dataService.setTitle(this.tmpAlarm.title);
  }

  //次ボタンクリック
  @Catch()
  async next() {
    //URLにアラーム情報を埋め込み設定画面へ遷移
    await this.router.navigate(
      ["/set"],
      {queryParams: this.tmpAlarm}
    );
  }

  //戻るボタンクリック
  @Catch()
  async back() {
    //タイマー一覧画面へ遷移
    await this.router.navigate(["/list"]);
  }

}
