import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';
import { FormGroup, FormControl, FormBuilder, Validators, ReactiveFormsModule } from '@angular/forms';
import { CustomValidators } from 'ng2-validation';

@Component({
  imports: [CommonModule, ReactiveFormsModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  constructor(private builder: FormBuilder) {}
  title = 'validation';

  url = new FormControl('',
    [
      Validators.required,
      CustomValidators.url
    ]
  );
  mail = new FormControl('hoge@example.com',
    [
      Validators.required,
      Validators.email
    ]
  );
  mail_confirm = new FormControl('',
    [
      CustomValidators.equalTo(this.mail)
    ]
  );

  myForm = this.builder.group({
    url: this.url,
    mail: this.mail,
    mail_confirm: this.mail_confirm
  });

  show(){
    console.log('URL： ' + this.url);
    console.log('メールアドレス： ' + this.mail);
    console.log('メールアドレス（確認）： ' + this.mail_confirm);
  }
}
