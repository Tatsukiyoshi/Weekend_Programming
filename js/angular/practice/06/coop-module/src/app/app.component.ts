import { Component } from '@angular/core';
import { Book } from './book';
import { CommonModule } from '@angular/common';
import { EditComponent } from './coop/edit.component';
import { DetailsComponent } from './coop/details.component';

@Component({
  imports: [CommonModule, DetailsComponent, EditComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'coop-edit';

  // 選択された書籍情報
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
    this.selected = {
      isbn: book.isbn,
      title: book.title,
      price: book.price,
      publisher: book.publisher
    };
  }

  // editedイベントが発生したタイミングで実行
  onedited(book: Book){
    // 引数bookで、対応する配列booksを更新
    for(let item of this.books){
      if(item.isbn === book.isbn){
        item.title = book.title;
        item.price = book.price;
        item.publisher = book.publisher;
      }
    }
    // 選択された書籍情報を空に（＝フォームを非表示にする）
    this.selected.isbn = "";
    this.selected.title = "";
    this.selected.price = 0;
    this.selected.publisher = "";
  }
}
