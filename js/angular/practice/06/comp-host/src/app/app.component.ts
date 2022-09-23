import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  host: {
    '(click)': 'onclick($event)',
    'role': 'banner',
    '[class.disabled]': 'true',
  }
})
export class AppComponent {
  title = 'comp-host';

  onclick(e: any){
    console.log(e.target);
  }
}
