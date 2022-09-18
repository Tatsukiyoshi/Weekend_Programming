import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'select-group';
  selected = 'dog';

  // 選択ボックスのオプション
  // error TS7053: Element implicitly has an 'any' type 
  // because expression of type 'string' can't be used to index type
  // -> indexがstringであることを明示する
  data: {[index: string]: any } = {
    '哺乳類': [
      { label: '犬',        value: 'dog',      disabled: false },
      { label: '猫',        value: 'cat',      disabled: false },
      { label: 'ハムスター', value: 'hamster', disabled: false },
    ],
    '魚類': [
      { label: '金魚',   value: 'fish',         disabled: true },
      { label: '鯉',     value: 'carp',         disabled: false },
      { label: '熱帯魚', value: 'tropical fish', disabled: false },
    ],
    '爬虫類': [
      { label: '亀',     value: 'turtle', disabled: false },
      { label: 'トカゲ', value: 'lizard', disabled: false },
      { label: 'ヘビ',   value: 'snake',  disabled: false }
    ]
  };

  // 与えられたハッシュのキーを配列として取得
  keys(obj: Object){
    return Object.keys(obj);
  }

  // 選択ボックスを変更したタイミングで、その選択値をログに出力
  show(){
    console.log('現在値：' + this.selected);
  }
}
