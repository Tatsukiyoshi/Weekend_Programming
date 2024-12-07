import { Component, OnInit } from "@angular/core";
import { ChildComponent } from "./child.component";

@Component({
    imports: [ChildComponent],
    selector: 'my-noparent',
    template: `
        <h2>NoParentComponent</h2>
        <my-child></my-child>
    `,
})
export class NoParentComponent {}
