import { Component } from "@angular/core";
import { UseService } from "./use.service";

@Component({
    selector: 'my-use',
    providers: [
        { provide: UseService, useClass: UseService }
    ],
    template: `<li>UseService : {{current}}</li>`
})
export class UseComponent {
    current: string;

    // UseService#showメソッドで、サービスの生成時刻を表示
    constructor(private use: UseService) {
        this.current = use.show();
    }
}
