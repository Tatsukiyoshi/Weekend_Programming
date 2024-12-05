import { Component } from '@angular/core';
import { ParentComponent } from './parent.component';
import { ChildComponent } from './child.component';

@Component({
  imports: [ParentComponent, ChildComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'life-content';
}
