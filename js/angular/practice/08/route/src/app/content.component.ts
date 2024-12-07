import { Component } from "@angular/core";
import { ActivatedRoute, Params, RouterModule } from "@angular/router";

@Component({
    imports: [RouterModule],
    templateUrl: './content.component.html',
    styles: ['.current { background-color: #ff0; }']
})
export class ContentComponent {
    id = '';

    constructor(private route: ActivatedRoute) {}

    // :idパラメータを取得＆ページに反映
    ngOnInit(){
        this.route.params.subscribe(params => this.id = params['id']);
    }
}
