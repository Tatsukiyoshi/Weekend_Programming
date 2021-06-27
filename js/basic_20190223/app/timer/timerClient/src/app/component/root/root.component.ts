//====================
// ルートコンポーネント
//　・コンポーネント共通の処理
//　　ヘッダー、メニュー、画面関連イベント検知
//====================

import {Component, HostListener, OnInit} from '@angular/core';
import {Router} from '@angular/router';
import {DataService} from '../../service/data.service';
import {Catch} from '../../class/log.class';
import {ThemePalette} from '@angular/material';


@Component({
  selector: 'app-root',
  templateUrl: './root.component.html',
  styleUrls: ['../../common.css', './root.component.css']
})
export class RootComponent implements OnInit {

    myHeaderColor:ThemePalette="primary";
  constructor(
    public router: Router,
    public dataService: DataService) {
  }

  ngOnInit() {
      this.myHeaderColor=this.dataService.state.theme as ThemePalette;
  }

  //ブラウザが閉じるイベントを検出
  @HostListener("window:beforeunload", ["$event"])
  beforeUnload(e: Event) {
    this.dataService.onBeforeUnload();
  }

//====================
// メニューの選択
//====================

  //Push通知ON/OFF
  @Catch()
  async toggleEnablePush() {
    if (this.dataService.isEnablePush) {
      this.dataService.isEnablePush = false;
    } else {
      let ret = await this.dataService.getPermission();
      this.dataService.isEnablePush = ret;
    }
  }

    //テーマ切り替え
  @Catch()
  changeTheme(color: ThemePalette) {
      this.myHeaderColor=color;
      this.dataService.theme = color;
  }

  //リセット
  @Catch()
  async initApp() {
    this.dataService.initApp();
  }

  //トップページへ戻る
  @Catch()
  async goHome() {
    await this.router.navigate(['/']);
  }

}
