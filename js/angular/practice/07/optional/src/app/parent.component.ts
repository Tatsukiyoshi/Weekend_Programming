import { Component, OnInit } from "@angular/core";
import { UseService } from "./use.service";

@Component({
    selector: 'my-parent',
    providers: [ UseService ],
    template: `
        <h2>ParentComponent</h2>
        <my-child></my-child>
    `,
})
export class ParentComponent {}
