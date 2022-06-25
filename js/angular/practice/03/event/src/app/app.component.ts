import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'event';

  // 初期表示
  msg = '---';

  // ボタンクリック時に現在時刻を表示
  show(e: any): void{
    this.msg = new Date().toLocaleString();
    console.log(e);
  }
}
