import { CommonModule } from '@angular/common';
import { Component } from '@angular/core';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'clazz';

  // スタイル情報を定義
  styles = {
    back  : false,
    fore  : false,
    space : false
  };
}
