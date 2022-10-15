import { Component, OnInit, Optional } from "@angular/core";
import { UseService } from "./use.service";

@Component({
    selector: 'my-child',
    template: `
        <p>{{current}}</p>
    `,
})
export class ChildComponent implements OnInit {
    current = '';

    constructor(@Optional() private use: UseService) {}

    // サービスが存在しない場合には、処理をスキップ
    ngOnInit(): void {
        if(this.use){
            this.current = this.use.show();
        }
    }
}
