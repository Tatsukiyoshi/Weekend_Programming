import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'plural-18n';

  favs = ['山田理央', '鈴木洋平', '腰掛奈美'];
  messages = {
    '=0': '［いいね！］されていません。',
    '=1': '1人だけ［いいね！］と言ってくれています。',
    'other': '#人が［いいね！］と言っています。'
  };
}
