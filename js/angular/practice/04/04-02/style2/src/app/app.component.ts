import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'style2';
  back = false;   // 背景色のオンオフ
  fore = false;   // 前景色のオンオフ
  space = false;  // 余白のオンオフ

  get styles(){
    return {
      'background-color': this.back ? '#f00' : '',
      'color'           : this.fore ? '#fff' : '#000',
      'padding.px'      : this.space ? 15 : 5 
    };
  }
}
