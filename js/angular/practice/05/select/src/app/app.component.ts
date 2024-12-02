import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [FormsModule, CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'select';
  selected = 'hamster';

  // 選択ボックスのオプション
  data = [
    { label: '犬', value: 'dog', disabled: false },
    { label: '猫', value: 'cat', disabled: false },
    { label: 'ハムスター', value: 'hamster', disabled: false },
    { label: '金魚', value: 'fish', disabled: true },
    { label: '亀', value: 'turtle', disabled: false }
  ];

  // 選択ボックスを変更したタイミングで、その選択値をログに出力
  show(){
    console.log('現在値：' + this.selected);
  }
}
