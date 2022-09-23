import { Component } from '@angular/core';
import { trigger, state, style, transition, animate, keyframes, group } from '@angular/animations';

@Component({
  selector: 'app-root',
  animations: [
    trigger('labelState', [
      transition('void => *', [
        animate(1000, keyframes([
          style({ transform: 'translateX(100%)', offset: 0}),
          style({ transform: 'translateX(50px)', offset: 0.1}),
          style({ transform: 'translateX(0)',    offset: 1})
        ]))
      ]),
      transition('* => void', [
        group([
          animate(800, style({ opacity: 0 })),
          animate('300ms 500ms', style({ transform: 'translateX(100%)'}))
        ])
      ])
    ])
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'anime-group';
  show = true;
}
