//(1)パッケージのインポート
import {
  AfterContentChecked,
  AfterContentInit,
  AfterViewChecked,
  AfterViewInit,
  Component,
  DoCheck,
  OnChanges,
  OnDestroy,
  OnInit
} from "@angular/core";
import {StoreService} from "./store.service";
import {NavigationStart, Router} from "@angular/router";

//(2)デコレーター
@Component({

  //(3)出力先タグ名
  selector: "app-root",

  //(4)HTMLテンプレート
  template: `
    <div class="header">
      ルートコンポーネント 閲覧回数
      {{storeService.getCounter()}}回
    </div>
    <router-outlet></router-outlet>`,

  //(5)CSS
  styles: [
      `.header {
      display: flex;
      background-color: steelblue;
      color: white;
      font-weight: bold;
      height: 3em;
      align-items: center;
      justify-content: center
    }`
  ]
})
//(6)クラス定義
export class RootComponent implements OnChanges, OnInit,
  DoCheck, AfterContentInit, AfterContentChecked,
  AfterViewInit, AfterViewChecked, OnDestroy {

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
