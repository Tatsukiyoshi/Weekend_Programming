import { Component } from '@angular/core';
import { HttpClient, HttpHeaders, HttpRequest } from '@angular/common/http'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'upload';

  // Httpサービスを有効化
  constructor(private http:HttpClient) {}

  // ファイルを選択したら、アップロードを実行
  upload(list: any){
    // アップロードファイルがなければ、処理を中止
    if(list.length <= 0){ return; }

    // アップロードファイルを準備
    let f = list[0];
    let data = new FormData();
    data.append('upfile', f, f.name);

    // サーバにデータを送信
    this.http.post('app/upload.php', data)
      // 成功／失敗時には、それぞれ結果をログに表示
      .subscribe(
        data => console.log(data),
        error => console.log(error)
      );
  }
}
