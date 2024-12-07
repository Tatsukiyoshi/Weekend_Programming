import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [CommonModule, FormsModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'change';

  max = 140;        // 入力可能な最大長
  tweet = '';       // テキストエリアの初期値
  count = this.max; // 入力可能な文字数
  myStyle = { color: '#00f', fontweight: 'normal' };  // 残り文字数のスタイル

  // テキストエリアの変更を監視
  setcolor(){
    // 残り文字数を反映
    this.count = this.max - this.tweet.length;

    // 残り文字数に応じて、スタイルを変更
    if(this.count > 10){
      this.myStyle = { color: '#00f', fontweight: 'normal' };
    } else if (this.count > 0){
      this.myStyle = { color: '#f0f', fontweight: 'normal' };
    } else {
      this.myStyle = { color: '#f00', fontweight: 'bold' };
    }
  }
}
