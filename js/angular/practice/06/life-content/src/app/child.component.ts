import { Component } from '@angular/core';

@Component({
  selector: 'my-child',
  templateUrl: './child.component.html',
  styleUrls: ['./child.component.css']
})
export class ChildComponent {
  poem!: string;
}
