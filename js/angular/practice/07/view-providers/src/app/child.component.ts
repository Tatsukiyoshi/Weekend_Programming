import { Component } from '@angular/core';
import { UseService } from './use.service';

@Component({
    selector: 'my-child',
    template: `<div>UseService : {{current}}</div>`
})
export class ChildComponent {
    current: string;

    // UseServiceサービスで現在時刻を表示
    constructor(private use: UseService) {
        this.current = use.show();
    }
}
