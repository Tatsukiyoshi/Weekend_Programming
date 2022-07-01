import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'select';

  members = [
    {name: '佐藤リオ', sex: 'female' },
    {name: '田中聡', sex: 'male' },
    {name: '郷田瑞樹', sex: 'unknown' }
  ];

  // 性別に応じたメッセージを準備
  messages = {
    'male':   '彼',
    'female': '彼女',
    'other':  '彼／彼女'
  };
}
