import { Component } from '@angular/core';

@Component({
  selector: 'my-app',
  template: `<img [src]="image" />`
})
export class AppComponent {
  image = 'https://www.wings.msn.to/image/wings.jpg';
}
