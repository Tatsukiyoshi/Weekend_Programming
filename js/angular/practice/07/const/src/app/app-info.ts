import { InjectionToken } from "@angular/core";

export const MY_APP_INFO = {
    title: 'Angularサンプル',
    author: 'YAMADA, Yoshihiro',
    created: new Date(2017, 2, 14)
};
export let APP_INFO = new InjectionToken('my.app.info');
