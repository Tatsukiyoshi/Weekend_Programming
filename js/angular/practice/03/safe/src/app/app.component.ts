import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  template: `<div>{{member.name}}</div>`
})
export class AppComponent {
  title = 'safe';
  member = {
    name: "山田太郎",
    age: 30
  };
}
