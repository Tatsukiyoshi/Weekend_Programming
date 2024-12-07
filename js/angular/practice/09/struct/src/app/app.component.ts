import { Component } from '@angular/core';
import { DeadlineDirective } from './deadline.directive';

@Component({
  imports: [DeadlineDirective],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'struct';
  end = new Date(2024, 11, 24); // 2024/12/24
}
