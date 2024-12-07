import { Component } from '@angular/core';
import { UseService } from './use.service';
import { ParentComponent } from './parent.component';
import { ChildComponent } from './child.component';

@Component({
  imports: [ParentComponent, ChildComponent],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'view-providers';
}
