import { Injectable } from "@angular/core";

@Injectable()
export class UseService {
    created: Date;

    // インスタンス生成の時刻を記録
    constructor() {
        this.created = new Date();
        this.sleep(2000);   // 2秒処理を遅延
    }

    // createdプロパティの値を整形
    show() {
        return this.created.toLocaleString();
    }

    // delayミリ秒だけ処理を遅延
    sleep(delay: number) {
        let tmp1 = new Date();
        while(true) {
            let tmp2 = new Date();

            // tmp1～tmp2間がdelayミリ秒を超えた場合、処理を終了
            if(tmp2.getTime() - tmp1.getTime() > delay) {
                return;
            }
        }
    }
}
