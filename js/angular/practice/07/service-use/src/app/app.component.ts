import { Component } from '@angular/core';
import { UseService } from './use.service';
import { UseComponent } from './use.component';

@Component({
  imports: [UseComponent],
  selector: 'app-root',
  providers: [
    {provide: UseService, useClass: UseService }
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'service-use';
}
