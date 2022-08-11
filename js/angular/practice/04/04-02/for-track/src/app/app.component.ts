import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'for-track';

  // 書籍情報を準備
  books = [
    {
      isbn: '978-4-7741-8411-1',
      title: '改訂新版JavaScript本格入門'
    },
    {
      isbn: '978-4-7980-4853-6',
      title: 'はじめてのAndroidアプリ開発 第2版'
    },
    {
      isbn: '978-4-7741-8030-4',
      title: '［改訂新版］Javaポケットリファレンス'
    }
  ];

  // [更新]ボタンクリックで、新規データを置き換え
  onclick(){
    this.books = [
      {
        isbn: '978-4-7741-8411-1',
        title: '改訂新版JavaScript本格入門'
      },
      {
        isbn: '978-4-7980-4853-6',
        title: 'はじめてのAndroidアプリ開発 第2版'
      },
      {
        isbn: '978-4-7741-8030-4',
        title: '［改訂新版］Javaポケットリファレンス'
      },
      {
        isbn: '978-4-7981-3547-2',
        title: '独習PHP 第3版'
      },
    ];
  }
  // トラッキング式を準備
  trackFn(index: any, book: any){
    return book.isbn;
  }
}
