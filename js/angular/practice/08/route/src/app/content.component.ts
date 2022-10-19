import { Component } from "@angular/core";
import { ActivatedRoute, Params } from "@angular/router";

@Component({
    templateUrl: './content.component.html',
    styles: ['.current { backgroud-color: #ff0; }']
})
export class ContentComponent {
    id = '';

    constructor(private route: ActivatedRoute) {}

    // :idパラメータを取得＆ページに反映
    ngOnInit(){
        this.route.params.subscribe(params => this.id = params['id']);
    }
}
