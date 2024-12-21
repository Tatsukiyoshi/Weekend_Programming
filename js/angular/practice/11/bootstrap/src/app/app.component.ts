import { Component } from '@angular/core';
import { AccordionConfig, AccordionModule } from 'ngx-bootstrap/accordion';

@Component({
  imports: [AccordionModule],
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css'],
  providers: [
    {
      provide: AccordionConfig,
      useFactory: () => {
        return Object.assign(new AccordionConfig(), { closeOthers: true });
      }
    }
  ]
})
export class AppComponent {
  title = 'bootstrap';
}
