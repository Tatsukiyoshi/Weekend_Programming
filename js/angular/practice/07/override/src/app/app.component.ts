import { Component } from '@angular/core';
import { OverService } from './over.service';

@Component({
  selector: 'app-root',
  providers: [
    { provide: OverService, useClass: OverService }
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'override';
  constructor(public over: OverService) {}
}
