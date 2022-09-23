import { Component } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
  selector: 'app-root',
  animations: [
    trigger('btnState', [
      // 状態off, onを定義
      state('off', style({
        border: 'none',
        backgroundColor: '#000',
        color: '#fff',
        fontWeight: 'normal',
        transform: 'scale(0.8) rotate(0deg)'
      })),
      state('on', style({
        border: 'solid 1px #fff',
        backgroundColor: '#f00',
        color: '#fff',
        fontWeight: 'bold',
        transform: 'scale(1) rotate(5deg)'
      })),
      // 遷移情報を定義
      transition('off => on', animate('200ms linear')),
      transition('on => off', animate('200ms linear'))
    ])
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'anime';
  flag = 'off';     // 状態を管理する
  caption = 'オフ'  // ボタンキャプション

  // ボタンクリックでflag/captionプロパティを反転
  toggle() {
    this.flag = (this.flag === 'on' ? 'off' : 'on');
    this.caption = (this.caption === 'オン' ? 'オフ' : 'オン');
  }
}
