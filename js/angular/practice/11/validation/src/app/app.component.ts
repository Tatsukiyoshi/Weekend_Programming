import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'validation';
  user = {
    url: '',
    mail: 'hoge@example.com',
    mail_confirm: ''
  };

  show(){
    console.log('URL： ' + this.user.url);
    console.log('メールアドレス： ' + this.user.mail);
    console.log('メールアドレス（確認）： ' + this.user.mail_confirm);
  }
}
