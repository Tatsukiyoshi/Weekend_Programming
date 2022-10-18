import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
    template: `
        <ul>
            <li>キーワード：{{keyword}}</li>
        </ul>
    `
})
export class SearchComponent implements OnInit {
    keyword = '';

    // ActivatedRouteサービスをインスタンス化
    constructor(private route: ActivatedRoute) {}

    // 可変長のパラメータを取得
    ngOnInit(): void {
        this.route.url.subscribe(strs => {
            this.keyword = strs.join(` `);
        });
    }
}
