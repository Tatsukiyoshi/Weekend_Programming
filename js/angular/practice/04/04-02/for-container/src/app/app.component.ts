import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'for-container';
  articles = [
    {
      title: '改訂新版JavaScript本格入門',
      body: '「ECMAScript 2015」による新記法はもちろん...',
      author: '山田祥寛'
    },
    {
      title: 'Swiftポケットリファレンス',
      body: 'iOSのフレームワークの解説から全く新しい...',
      author: '片渕彼富'
    },
    {
      title: '［改訂新版］Javaポケットリファレンス',
      body: '初版でのJava SE 6までの標準ライブラリに...',
      author: '高江賢'
    },
  ];
}
