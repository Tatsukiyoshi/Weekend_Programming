import { Component } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { firstValueFrom } from 'rxjs';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'in-memory';
  books: any[] = [];

  // Httpサービスをインスタンス化
  constructor(private http: HttpClient){}

  // コンポーネントの初期化時に書籍情報を取得
  ngOnInit() {
    this.getAll();
  }

  // 議事データベースから書籍情報を取得
  async getAll() {
    const res = await firstValueFrom(this.http.get('/api/books'));
    console.log(res);
  }
}
