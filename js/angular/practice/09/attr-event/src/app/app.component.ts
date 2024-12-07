import { Component } from '@angular/core';
import { ColoredDirective } from './colored.directive';

@Component({
  imports: [ColoredDirective],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'attr-event';
}
