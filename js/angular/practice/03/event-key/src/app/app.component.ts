import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'event-key';

  which = '';
  altKey = false;
  ctrlKey = false;
  shiftKey = false;

  // キー押下時に、キー情報を表示
  show(e: any){
    this.which = e.which;
    this.altKey = e.altKey;
    this.ctrlKey = e.ctrlKey;
    this.shiftKey = e.shiftKey;
  }
}
