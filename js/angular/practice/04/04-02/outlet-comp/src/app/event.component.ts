import { Component } from '@angular/core';

@Component({
  selector: 'my-event',
  template: `
    <div class="event">
        <h3>半額セール中！</h3>
        <p>今がチャンス。欲しかったあの商品も50％OFF。</p>
    </div>
  `,
  styleUrls: ['./app.component.css']
})
export class EventComponent {
}
