import { Component } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';

@Component({
  imports: [FormsModule, CommonModule],
  selector: 'app-root',
  animations: [
    // labelStateトリガを宣言
    trigger('labelState', [
      // 状態activeを宣言
      state('active', style({ transform: 'translateX(0)' })),
      // 表示時の遷移を宣言
      transition('void => active', [
        style({ transform: 'translateX(100%)'}),
        animate(300)
      ]),
      // 非表示時の遷移を宣言
      transition('active => void', [
        animate(300, style({ transform: 'translateX(100%)'}))
      ])
    ])
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'anime-event';
  show = true;

  // アニメーションの開始／終了時にイベント情報をログ出力
  onanim(e: any){
    console.log(e);
  }
}
