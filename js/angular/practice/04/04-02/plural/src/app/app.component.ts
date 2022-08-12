import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'plural';
  favs: string[] = [ '山田理央', '鈴木洋平', '腰掛奈美' ];
}
