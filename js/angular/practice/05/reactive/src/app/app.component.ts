import { Component } from '@angular/core';
import { FormGroup, FormControl,
          FormBuilder, Validators } from '@angular/forms'

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reactive';
  myForm!: FormGroup;

  // 個々の入力要素（初期値と検証ルール）を宣言
  mail = new FormControl('hoge@example.com', [
    Validators.required,
    Validators.email
  ]);

  passwd = new FormControl('', [
    Validators.required,
    Validators.minLength(6)
  ]);

  name = new FormControl('名無権兵衛', [
    Validators.required,
    Validators.minLength(3),
    Validators.maxLength(10)
  ]);

  memo = new FormControl('メモ', [
    Validators.maxLength(10)
  ]);

  // FormBuilderオブジェクトを生成
  constructor(private builder: FormBuilder){
    // FormGroupオブジェクトを生成
    this.myForm = this.builder.group({
      mail: this.mail,
      passwd: this.passwd,
      name: this.name,
      memo: this.memo
    });
  }

  // サブミット時に入力値を反映
  show(){
    console.log('メールアドレス：' + this.mail.value);
    console.log('パスワード：' + this.passwd.value);
    console.log('名前（漢字）：' + this.name.value);
    console.log('備考：' + this.memo.value);
    console.log('すべて：');
    console.log(this.myForm.value);
  }
}
