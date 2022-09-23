import { Component } from '@angular/core';
import { trigger, state, style, transition, animate } from '@angular/animations';

@Component({
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
  title = 'anime-void';
  show = true;
}
