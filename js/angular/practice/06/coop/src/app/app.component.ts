import { Component } from '@angular/core';
import { Book } from './book';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'coop';

  // リスト側で選択された書籍
  selected: Book = new Book;
  // 書籍情報を準備
  books = [
    {
      isbn: '978-4-7741-8411-1',
      title: '改訂新版JavaScript本格入門',
      price: 2980,
      publisher: '技術評論社',
    },
    {
      isbn: '978-4-7980-4853-6',
      title: 'はじめてのAndroidアプリ開発 第2版',
      price: 3200,
      publisher: '秀和システム',
    }
  ];

  // リンククリック時に選択された書籍情報をselectedプロパティに保存
  onclick(book: Book){
    this.selected = book;
  }
}
