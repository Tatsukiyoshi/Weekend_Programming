import { Component, OnInit, OnDestroy } from '@angular/core';

import { EventComponent } from './event.component';
import { BookComponent } from './book.component';
import { WingsComponent } from './wings.component';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit, OnDestroy {
  interval: any; // タイマー
  title = 'outlet-comp';
  comps = [ EventComponent, BookComponent, WingsComponent ];
  current = 0;                  // 現在のコンポーネント（インデックス値）
  banner: any = EventComponent; // 現在のコンポーネント（オブジェクト）

  // コンポーネント切り替えのためのタイマーを準備
  ngOnInit() {
    this.interval = setInterval(() => {
      // インデックスを更新し、コンポーネントを変更
      this.current = (this.current + 1) % this.comps.length;
      this.banner = this.comps[this.current];
    }, 3000);
  }

  // コンポーネント破棄の際にタイマーを破棄
  ngOnDestroy(): void {
      clearInterval(this.interval);
  }
}
