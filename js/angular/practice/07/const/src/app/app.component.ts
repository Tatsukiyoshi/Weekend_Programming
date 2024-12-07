import { Component, Inject } from '@angular/core';
import { APP_INFO } from './app-info';
import { CommonModule } from '@angular/common';

@Component({
  imports: [CommonModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'const';

  constructor(@Inject(APP_INFO) private info: any){
    console.log(info);
  }
}
