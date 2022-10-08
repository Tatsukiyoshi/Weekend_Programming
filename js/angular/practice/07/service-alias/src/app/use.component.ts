import { Component } from "@angular/core";
import { UseService } from "./use.service";
import { AliasService } from "./alias.service";

@Component({
    selector: 'my-use',
    
    // サービスインスタンスの生成方法を宣言
    providers: [
        {provide: UseService, useClass: UseService },
        {provide: AliasService, useExisting: UseService }
    ],
    template: `<li>UseService : {{current}}</li>`
})
export class UseComponent {
    current: string;

    // UseService#showメソッドで、サービスの生成時刻を表示
    constructor(private use: AliasService) {
        this.current = use.show();
    }
}
