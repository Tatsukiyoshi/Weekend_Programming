import { Directive, Input, OnChanges, SimpleChanges, TemplateRef, ViewContainerRef } from "@angular/core";

@Directive({
    selector: '[myDeadline]'
})
export class DeadlineDirective implements OnChanges {
    // 期限を表すmyDeadline属性を宣言
    @Input('myDeadline')
    deadline!: Date;

    // TemplateRef／ViewContainerRefオブジェクトを準備
    constructor(private templateRef : TemplateRef<any>,
        private viewContainer: ViewContainerRef) {
    }

    // myDeadline属性を変更したときに、テンプレートの表示／非表示を判定
    ngOnChanges(changes: SimpleChanges): void {
        if (this.deadline.getTime() < new Date().getTime()){
            this.viewContainer.clear();
        } else {
            this.viewContainer.createEmbeddedView(this.templateRef);
        }
    }
}
