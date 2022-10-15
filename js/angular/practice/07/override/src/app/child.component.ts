import { Component } from "@angular/core";
import { OverService, SpecialOverService } from "./over.service";

@Component({
    selector: 'my-child',

    // 同一のOverServiceトークンを上書き
    providers: [
        { provide: OverService, useClass: SpecialOverService }
    ],
    template: `
        <p>ChildComponent : {{over.show()}}</p>
    `
})
export class ChildComponent {
    // 注入のキーはあくまでOverService
    constructor(public over: OverService) {}
}
