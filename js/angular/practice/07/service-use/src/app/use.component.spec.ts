import { ComponentFixture, TestBed } from '@angular/core/testing';
import { DebugElement } from '@angular/core';
import { By } from '@angular/platform-browser';

import { UseComponent } from './use.component';
import { UseService } from './use.service';

describe('UseComponent', () => {
    let service: UseService;
    let current: Date;
    let de: DebugElement;
    let comp: UseComponent;
    let fixture: ComponentFixture<UseComponent>;

    beforeEach(() => {
        current = new Date(2017, 3, 1);

        // UseServiceサービスのスタブを準備
        let serviceStub = {
            show(){
                return current.toLocaleString();
            }
        };

        // テストモジュールを準備
        TestBed.configureTestingModule({
            declarations: [ UseComponent ]
        }).overrideComponent(UseComponent, { // コンポーネントの設定をオーバーライド
            set: {
                providers: [
                    { provide: UseService, useValue: serviceStub }
                ]
            }
        });

        // コンポーネントを準備
        fixture = TestBed.createComponent(UseComponent);
        comp = fixture.componentInstance;
        de = fixture.debugElement.query(By.css('li'));

        // 依存サービスを取得
        service = fixture.debugElement.injector.get(UseService);
    });

    it('<li>要素のテキストを確認', () => {
        fixture.detectChanges();

        // 生成されたテキストが正しいかをチェック
        expect(de.nativeElement.textContent).
            toEqual('UseService : ' + current.toLocaleString());
    });
});
