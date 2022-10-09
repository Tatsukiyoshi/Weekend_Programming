import { Component, Inject, OnInit } from '@angular/core';

import { Book } from './book';
import { BookService } from './book.service';
import { Hoge } from './hoge';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'provide';

  books: Book[] = [];

  // BookServiceサービスをインスタンス化
  constructor(@Inject(Hoge) private bookservice: BookService){}

  // コンポーネント初期化時に、サービス経由で書籍情報を取得
  ngOnInit(){
    this.books = this.bookservice.getBooks();
  }
}
