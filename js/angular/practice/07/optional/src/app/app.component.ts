import { Component } from '@angular/core';
import { ParentComponent } from './parent.component';
import { NoParentComponent } from './no-parent.component';

@Component({
  imports: [ParentComponent, NoParentComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'optional';
}
