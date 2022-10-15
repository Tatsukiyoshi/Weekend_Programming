import { Component } from "@angular/core";
import { UseService } from "./use.service";

@Component({
    selector: 'my-use',
    
    // サービスインスタンスの生成方法を宣言
    providers: [
        {provide: UseService, useFactory: () => {
                let service = new UseService();
                // 秒／ミリ秒を切り捨て
                service.created.setSeconds(0);
                service.created.setMilliseconds(0);
                return service;    
            }
        }
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
