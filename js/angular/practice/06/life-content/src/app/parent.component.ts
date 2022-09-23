import { Component, AfterContentChecked, ContentChild } from '@angular/core';

import { ChildComponent } from './child.component';

@Component({
  selector: 'my-parent',
  templateUrl: './parent.component.html',
  styleUrls: ['./parent.component.css']
})
export class ParentComponent implements AfterContentChecked {
  // ChildComponentを取得
  @ContentChild(ChildComponent)
  child!: ChildComponent;
  poem = '';

  // 外部コンテンツの確認後に処理
  ngAfterContentChecked() {
    if(this.poem != this.child.poem) {
      this.poem = this.child.poem;
    }
  }
}
