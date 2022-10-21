import { Directive, ElementRef, Input, OnInit } from "@angular/core";

@Directive({
    selector: '[myColored]'
})
export class ColoredDirective implements OnInit {
    @Input('myColored') color = '#cff';

    constructor(private el: ElementRef){

    }

    ngOnInit(): void {
        this.el.nativeElement.style.backgroundColor = this.color;
    }
}
