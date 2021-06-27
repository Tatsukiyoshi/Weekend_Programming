//(1)パッケージのインポート
import {
  AfterContentChecked,  AfterContentInit,  AfterViewChecked,
  AfterViewInit,  Component,  DoCheck,  OnChanges,
  OnDestroy,  OnInit} from "@angular/core";
import {StoreService} from "./store.service";
import {Router} from "@angular/router";
import {Title} from "@angular/platform-browser";

//(2)デコレーター
@Component({

  //(3)出力先タグ名
  selector: "page02",

  //(4)HTMLテンプレート
  template: `
    <div class="box">
      <p>親コンポーネント（2/2）</p>
      <!--子コンポーネント出力先-->
      <child-comp [childValue]="value02"></child-comp>
      <p>前ページの金額　\{{value02 | number}}-</p>
      <p>
        <button (click)="clickButton($event)">1ページ目へ</button>
      </p>
    </div>
  `,

  //(5)CSS
  styles: [
    `.box {
      border: gray solid 2px;
      padding: 1em;
    }`
  ]
})
//(6)クラス定義
export class Page02Component implements OnChanges, OnInit,
  DoCheck, AfterContentInit,  AfterContentChecked, AfterViewInit,
  AfterViewChecked, OnDestroy {

  //(7)前ページで入力された金額
  value02;

  //(8)コンストラクタ(サービスのDI)
  constructor(
    private storeService: StoreService,
    private title: Title,
    private router: Router
  ) {
    console.log("@@@constructor");
  }

  //(9)初期化処理
  ngOnInit() {
    console.log("@@@ngOnInit");
    //ページタイトルの設定
    this.title.setTitle("page02");
    //サービスが保存している入力金額を取得
    this.value02 = this.storeService.getStore();
  }

  //(10)1ページ目へ戻るボタン
  clickButton(event) {
    console.log("■■■" + event.target.tagName);
    this.router.navigate(["page01"]);
  }

  //(11)以降はイベント履歴の記録用
  ngOnChanges() {
    console.log("@@@ngOnChanges");
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

  ngOnDestroy() {
    console.log("@@@ngOnDestroy");
  }

}
