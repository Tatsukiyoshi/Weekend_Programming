import { Component, OnInit } from "@angular/core";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
    template:`
    `,
})

export class DataComponent implements OnInit {
    // ActivatedRouteサービスをインスタンス化
    constructor(private route: ActivatedRoute) {}

    // dataプロパティの値を取得
    ngOnInit(): void {
        this.route.data.subscribe(obj => console.log(obj['category']));
    }
}
