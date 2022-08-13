import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'form-basic';

  // ユーザ情報の初期値
  user = {
    mail: 'hoge@example.com',
    passwd: '',
    name: '名無権兵衛',
    memo: 'メモ'
  };

  // ［送信］ボタンのクリックで入力値をログに出力
  show(){
    console.log('メールアドレス：' + this.user.mail);
    console.log('パスワード：' + this.user.passwd);
    console.log('名前：' + this.user.name);
    console.log('メモ：' + this.user.memo);
  }
}
