import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

import { map } from 'rxjs/operators';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'async';

  message!: Observable<string>;

  // Httpサービスをインスタンス化
  constructor(private http: HttpClient){}

  // コンポーネント初期化時にmessage.txtにアクセス
  ngOnInit(){
    this.message = this.http.get('app/message.txt')
      .pipe(map(Response => Response.toString()));
  }
}
