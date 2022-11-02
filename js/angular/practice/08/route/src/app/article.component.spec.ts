import { DebugElement } from "@angular/core";
import { ComponentFixture, TestBed } from "@angular/core/testing";
import { By } from "@angular/platform-browser";

import { ActivatedRoute } from "@angular/router";
import { ArticleComponent } from "./article.component";

import { Observable } from "rxjs";  // import { Observable } from 'rxjs/Observable';
import { of } from "rxjs";          // import 'rxjs/add/observable/of';

describe('ArticleComponent', () => {
    let service: ActivatedRoute;
    let de: DebugElement;
    let comp: ArticleComponent;
    let fixture: ComponentFixture<ArticleComponent>;

    // テストの前準備
    beforeEach(() => {
        // ActivatedRouteサービスのスタブを準備
        let ActivatedRouteStub = {
            get params() {
                // return Observavle.of( { id: 108 } );
                return of( { id: 108 } );
            }
        };

        // テストモジュールを準備
        TestBed.configureTestingModule({
            declarations: [ ArticleComponent ],
            providers: [
                { provide: ActivatedRoute, useValue: ActivatedRouteStub }
            ]
        });

        // コンポーネントを準備
        fixture = TestBed.createComponent(ArticleComponent);
        comp = fixture.componentInstance;
        de = fixture.debugElement.query(By.css('h1'));
        service = fixture.debugElement.injector.get(ActivatedRoute);
    });

    it('<h1>要素のテキストを確認', () => {
        fixture.detectChanges();
        let h1 = de.nativeElement;
        expect(h1.textContent).toEqual('記事情報 No.108');
    });
});
