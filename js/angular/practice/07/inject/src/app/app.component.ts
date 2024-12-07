import { Component, Injector } from '@angular/core';

import { Book } from './book';
import { BookService } from './book.service';
import { CommonModule } from '@angular/common';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'inject';

  books!: Book[];

  // Injectorサービスを有効化
  constructor(private injector: Injector){}

  // コンポーネント初期化時に、サービス経由で書籍情報を取得
  ngOnInit(){
    // インジェクター経由でサービスを取得
    let bookservice = this.injector.get(BookService);
    this.books = bookservice.getBooks();
  }
}
