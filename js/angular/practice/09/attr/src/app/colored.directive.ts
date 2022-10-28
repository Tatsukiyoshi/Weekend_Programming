import { Directive, ElementRef } from "@angular/core";

@Directive({
    selector: '[myColored]'
})
export class ColoredDirective {
    constructor(el: ElementRef){
        el.nativeElement.style.backgroundColor = '#cff';
    }
}
