import { Component } from '@angular/core';
import { Title } from '@angular/platform-browser';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  //title = 'temp-title';

  // Titleサービスを有効化
  constructor(private title: Title) {}

  // コンポーネント初期化時にタイトルを設定
  ngOnInit(){
    this.title.setTitle('Titleサービス');
  }
}
