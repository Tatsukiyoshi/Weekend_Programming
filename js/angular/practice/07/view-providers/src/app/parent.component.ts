import { Component } from '@angular/core';
import { UseService } from './use.service';

@Component({
    selector: 'my-parent',
    providers: [ UseService ],
    template: `
        <h3>ビュー</h3>
        <my-child></my-child>
        <h3>外部コンテンツ</h3>
        <ng-content></ng-content>
    `,
})
export class ParentComponent {}
