import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'http';
  name = '';
  result = '';

  // HttpClientサービスを注入
  constructor(private http: HttpClient){}

  // [送信]ボタンクリックで非同期通信を開始
  onclick(){
    this.http.get('http://localhost:8081/ServedForAngular/http', {
      params: { name: this.name },
    }).subscribe(
      // 通信成功時の処理（成功コールバック）
      response => {
        console.log(response);
      },
      // 通信失敗時の処理（失敗コールバック）
      error => {
        this.result = `通信失敗：${error.statusText}`;
      }
    );
  }
}
