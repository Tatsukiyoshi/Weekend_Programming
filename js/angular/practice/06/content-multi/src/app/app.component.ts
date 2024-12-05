import { Component } from '@angular/core';
import { ContentComponent } from './content.component';

@Component({
  imports: [ContentComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'content-multi';
}
