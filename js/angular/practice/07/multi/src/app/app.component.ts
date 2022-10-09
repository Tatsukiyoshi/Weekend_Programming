import { Component, Inject } from '@angular/core';
import { KEYWORDS } from './app-info';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'multi';

  // KEYWORDSサービスを注入し、その値をログ表示
  constructor(@Inject(KEYWORDS) private keywords: string[]) {
    console.log(keywords);
  }
}
