//(1)パッケージのインポート
import {
  AfterContentChecked, AfterContentInit, AfterViewChecked,
  AfterViewInit, Component, DoCheck, OnChanges,
  OnDestroy, OnInit
} from "@angular/core";
import {StoreService} from "./store.service";
import {FormControl} from "@angular/forms";
import {Router} from "@angular/router";
import {Title} from "@angular/platform-browser";

//(2)デコレーター
@Component({

  //(3)出力先タグ名
  selector: "page01",

  //(4)HTMLテンプレート
  template: `
    <div class="box">
      <p>親コンポーネント（1/2）</p>
      <p><input type="text" [formControl]="myForm"/></p>
      <p>入力金額　{{myForm.value}}</p>
      <p>
        <button (click)="clickButton($event)">次ページへ</button>
        <button (click)="dummy">何もしない</button>
      </p>
      <!--子コンポーネント出力先-->
      <child-comp [childValue]="myForm.value"
                  *ngIf="myForm.value"></child-comp>
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
export class Page01Component implements OnChanges, OnInit,
  DoCheck, AfterContentInit, AfterContentChecked, AfterViewInit,
  AfterViewChecked, OnDestroy {

  //(7)フォームコントロール
  myForm;

  //(8)コンストラクタ(サービスのDI)
  constructor(
    private storeService: StoreService,
    private router: Router,
    private title: Title
  ) {
    console.log("@@@constructor");
  }

  //(9)初期化処理
  ngOnInit() {
    console.log("@@@ngOnInit");
    //ページタイトルの設定
    this.title.setTitle("page01");
    //サービスが保存している入力金額を取得
    let value = this.storeService.getStore();
    //フォームコントロールを初期値を設定して生成
    this.myForm = new FormControl(value);
  }

  //(10)2ページ目に進むボタンのクリック
  clickButton(event) {
    console.log("■■■" + event.target.tagName);
    this.storeService.setStore(this.myForm.value);
    this.router.navigate(["page02"]);
  }

  //(11)何もしないボタンのクリック
  dummy() {
  }

  //(12)以降はイベント履歴の記録用
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

