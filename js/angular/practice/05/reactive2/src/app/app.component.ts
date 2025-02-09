import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormGroup, FormControl,
  FormBuilder, Validators, 
  ReactiveFormsModule} from '@angular/forms'

@Component({
  imports: [CommonModule, ReactiveFormsModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'reactive2';
  myForm!: FormGroup;

  // FormBuilderオブジェクトを生成
  constructor(private builder: FormBuilder){
    // FormGroupオブジェクトを生成
    this.myForm = this.builder.group({
      mail: new FormControl('hoge@example.com', [
        Validators.required,
        Validators.email
      ]),
      passwd: new FormControl('', [
        Validators.required,
        Validators.minLength(6)
      ]),
      name: new FormControl('名無権兵衛', [
        Validators.required,
        Validators.minLength(3),
        Validators.maxLength(10)
      ]),
      memo: new FormControl('メモ', [
        Validators.maxLength(10)
      ])
    });
  }

  // サブミット時に入力値を反映
  show(){
    console.log('メールアドレス：' + this.myForm.controls['mail'].value);
    console.log('パスワード：' + this.myForm.controls['passwd'].value);
    console.log('名前（漢字）：' + this.myForm.controls['name'].value);
    console.log('備考：' + this.myForm.controls['memo'].value);
    console.log('すべて：');
    console.log(this.myForm.value);
  }
}
