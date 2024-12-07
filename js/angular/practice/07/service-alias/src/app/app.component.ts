import { Component } from '@angular/core';
import { UseComponent } from './use.component';

@Component({
  imports: [UseComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'service-alias';
}
