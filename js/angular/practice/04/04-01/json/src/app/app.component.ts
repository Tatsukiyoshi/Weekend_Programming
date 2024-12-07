import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'json';

  obj: any = {
    name: 'トクジロウ',
    gender: undefined,
    birth: new Date(2007, 7, 15),
    age: 3,
    family: ['リンリン', 'サチ', 'ニンザブロウ'],
    work: function() {/* メソッドの中身 */},
    other: {
      favorite: 'ひまわり',
      memo: '偏屈爺さん'
    }
  };
}
