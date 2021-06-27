//(1)パッケージのインポート
import {
  AfterContentChecked,  AfterContentInit,  AfterViewChecked,
  AfterViewInit,  Component,  DoCheck,  Input,  OnChanges,
  OnDestroy, OnInit} from "@angular/core";

//(2)デコレーター
@Component({

  //(3)出力先タグ名
  selector: "child-comp",

  //(4)HTMLテンプレート
  template: `
    <div class="tax">
      <p class="header">子コンポーネント</p>
      <p>
        税込み金額 \\{{addTax(childValue) | number}}-
      </p>
      <p>登録時刻 {{getNow()}}</p>
    </div>
  `,
  //(5)CSS
  styles: [
      `.header {
      display: flex;
      justify-content: center;
      align-items: center;
    }`,
      `.tax {
      background-color: beige;
      border: gray solid 2px;
      padding: 1em;
    }`]
})
//(6)クラス定義
export class ChildComponent implements OnChanges, OnInit, DoCheck, AfterContentInit,
  AfterContentChecked, AfterViewInit, AfterViewChecked, OnDestroy {

  //(7)親コンポーネントから受け取るプロパティ
  @Input() childValue: number;

  //(8)コンストラクタ
  constructor() {
    console.log("@@@constructor");
  }

  //(9)税込み金額計算
  addTax(value: number) {
    console.log("■■■addTax");
    value *= 1.08; //税込み金額計算;
    return Math.floor(value);
  }

  //(10)現在時刻の取得
  getNow() {
    console.log("■■■getNow");
    return (new Date()).toLocaleTimeString();
  }

  //(11)以降はイベント履歴の記録用
  ngOnInit() {
    console.log("@@@ngOnInit");
  }

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
