import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'event-template';

  // 初期表示
  msg = '';

  // テキストボックスの変化に応じて、その内容をリスト表示
  show(input: string){
    this.msg += `<li>${input}</li>`;
  }
}
