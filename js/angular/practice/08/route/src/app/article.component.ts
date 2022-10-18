import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
    template: `
        <div>
            <h1>記事情報 No.{{id}}</h1>
            <p>この記事は、{{id}}番目の記事です。</p>
        </div>
    `
})

export class ArticleComponent implements OnInit {
    id = '';

    // ActivatedRouteサービスをインスタンス化
    constructor(private route: ActivatedRoute){}

    // :idパラメータを取得
    ngOnInit(): void {
        this.route.params.subscribe(
            params => this.id = params['id']
        );
    }
}
