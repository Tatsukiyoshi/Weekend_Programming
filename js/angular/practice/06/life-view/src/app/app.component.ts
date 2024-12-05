import { isNgTemplate } from '@angular/compiler';
import { Component, AfterViewChecked,
  QueryList, ViewChildren } from '@angular/core';

import { ChildComponent } from './child.component';

@Component({
  imports: [ChildComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'life-view';

  // ChildComponentを取得
  @ViewChildren(ChildComponent)
  children!: QueryList<ChildComponent>;

  // ChildComponentの入力値を格納する配列
  poems = ['', '', ''];

  // ビューの変更確認後に処理
  ngAfterViewChecked() {
    console.log('ngAfterViewChecked');

    // 子コンポーネントの値 poems
    this.children.forEach((item, index) => {
      if(this.poems[index] !== item.poem) {
        setTimeout(() => {
          this.poems[index] = item.poem;
        }, 0);
      }
    });
  }
}
