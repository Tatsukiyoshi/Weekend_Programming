import { Component } from '@angular/core';
import { trigger, state, style, transition, animate, keyframes } from '@angular/animations';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  imports: [CommonModule, FormsModule],
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
        animate(1000, keyframes([
          style({ transform: 'translateX(0)',    offset: 0}),
          style({ transform: 'translateX(50px)', offset: 0.9}),
          style({ transform: 'translateX(100%)', offset: 1})
        ]))
      ])
    ])
  ],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'anime-keyframes';
  show = true;
}
