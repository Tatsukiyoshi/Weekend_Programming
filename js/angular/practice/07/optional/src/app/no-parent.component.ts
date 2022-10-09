import { Component, OnInit } from "@angular/core";

@Component({
    selector: 'my-noparent',
    template: `
        <h2>NoParentComponent</h2>
        <my-child></my-child>
    `,
})
export class NoParentComponent {}
