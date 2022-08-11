import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'paging';
  start = 0;  // 表示開始位置
  len = 3;    // ページあたりの最大表示件数

  // 書籍情報を準備
  books = [
    {
      isbn: '978-4-7741-8411-1',
      title: '改訂新版JavaScript本格入門',
      price: 2980,
    },
    {
      isbn: '978-4-7980-4853-6',
      title: 'はじめてのAndroidアプリ開発 第2版',
      price: 3200,
    },
    {
      isbn: '978-4-7741-8030-4',
      title: '［改訂新版］Javaポケットリファレンス',
      price: 2680,
    },
    {
      isbn: '978-4-7981-3547-2',
      title: '独習PHP 第3版',
      price: 3200,
    },
    {
      isbn: '978-4-8222-9893-7',
      title: '基礎からしっかり学ぶC++の教科書',
      price: 2800,
    },
    {
      isbn: '978-4-7741-8883-6',
      title: 'Ruby on Rails 5 アプリケーションプログラミング',
      price: 3600,
    },
  ];

  // ページャークリック時の準備
  pager(page: number){
    this.start = this.len * page;
  }
}
