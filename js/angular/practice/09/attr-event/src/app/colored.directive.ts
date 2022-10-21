import { Directive, ElementRef, HostListener, Input } from "@angular/core";

@Directive({
    selector: '[myColored]'
})
export class ColoredDirective {
    @Input('myColored') color = '#cff';

    constructor(private el: ElementRef){

    }

    @HostListener('mouseenter') onmouseenter(){
        this.el.nativeElement.style.backgroundColor = this.color;
    }

    @HostListener('mouseleave') onmouseleave(){
        this.el.nativeElement.style.backgroundColor = '';
    }
}
