//(1)パッケージのインポート
import { Component } from '@angular/core';
import { AfterContentChecked } from '@angular/core';
import { AfterContentInit } from '@angular/core';
import { AfterViewChecked } from '@angular/core';
import { AfterViewInit } from '@angular/core';
import { DoCheck } from '@angular/core';
import { OnChanges } from '@angular/core';
import { OnDestroy } from '@angular/core';
import { OnInit } from '@angular/core';
import { StoreService } from './store.service';
import { NavigationStart } from '@angular/router';
import { Router } from '@angular/router';

//(2)デコレーター
@Component({
  //(3)出力先タグ名
  selector: 'app-root',
  //(4)HTMLテンプレート
  templateUrl: './app.component.html',
  //(5)CSS
  styleUrls: ['./app.component.css']
})
//(6)クラス定義
export class AppComponent implements OnChanges, OnInit,
  DoCheck, AfterContentInit, AfterContentChecked,
  AfterViewInit, AfterViewChecked, OnDestroy {

  title = 'sample02';

  //(7)ページ切り替え通知の予約
  subscription;

  //(8)コンストラクタ(サービスのDI)
  constructor(
    public storeService: StoreService,
    private router: Router
  ) {
    console.log("@@@constructor");
    //(9)ルータのページ切り替えイベント発生時の処理
    this.subscription = router.events.subscribe((event: any) => {
      if (event instanceof NavigationStart) {
        //(10)サービスが保管しているの閲覧回数を加算する
        storeService.addcounter();
      }
    });
  }

  //(11)リソース開放
  ngOnDestroy() {
    console.log("@@@ngOnDestroy");
    this.subscription.unsubscribe();
  }

  //(12)以降はイベント履歴の記録用
  ngOnChanges() {
    console.log("@@@ngOnChanges");
  }

  ngOnInit() {
    console.log("@@@ngOnInit");
  }

  ngDoCheck() {
    console.log("@@@ngDoCheck");
  }

  ngAfterContentInit() {
    console.log("@@@ngAfterContentInit");
  }

  ngAfterContentChecked() {
    console.log("@@@ngAfterContentChecked");
  }

  ngAfterViewInit() {
    console.log("@@@ngAfterViewInit");
  }

  ngAfterViewChecked() {
    console.log("@@@ngAfterViewChecked");
  }
}
