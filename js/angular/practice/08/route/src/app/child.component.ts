import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
    template: `
        <h3>ページ番号：{{page}}</h3>
    `
})
export class ChildComponent implements OnInit {
    page = '';

    // ActivatedRouteサービスをインスタンス化
    constructor(private route: ActivatedRoute) {}

    // :pageパラメータを取得
    ngOnInit(): void {
        this.route.params.subscribe(params => {
            console.log(params);
            this.page = params['page']
        });
    }
}
