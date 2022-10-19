import { Injectable } from "@angular/core";
import { CanActivate, ActivatedRouteSnapshot, RouterStateSnapshot, UrlTree } from "@angular/router";
import { Observable } from "rxjs";

@Injectable()
export class TimeGuard implements CanActivate {
    // ガードの実処理
    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        // 期限
        let limit = new Date(2017, 4, 30);
        let current = new Date();

        // 現在時刻が期限を過ぎている場合は、遷移をガード
        if(limit.getTime() > current.getTime()){
            return true;
        } else {
            window.alert('記事の公開期限を過ぎています。');
            return false;
        }
    }
}
