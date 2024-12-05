import { CommonModule } from '@angular/common';
import { Component, OnInit } from '@angular/core';
import { Meta } from '@angular/platform-browser';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'meta';

  // Metaサービスをインスタンス化
  constructor(private meta: Meta){}

  // コンポーネント初期化時にメタ情報を追加
  ngOnInit(): void {
      this.meta.addTag({
        name: 'author',
        content: 'Tatsukiyoshi'
      });
  }
}
