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
    let spy: jasmine.Spy;

    // テストの前準備
    beforeEach(() => {
        current = new Date(2017, 3, 1);
        TestBed.configureTestingModule({
            declarations: [ UseComponent ]
        }).overrideComponent(UseComponent, {    // UseComponentコンポーネントの設定を上書き
            set: {
                // UseServiceをインスタンス化する際に、スパイを設定
                providers: [
                    {
                        provide: UseService,
                        useFactory: () => {
                            let svc = new UseService();
                            spy = spyOn(svc, 'show').and.returnValue(current.toLocaleString());

                            return svc;
                        }
                    }
                ]
            }
        });

        // コンポーネントを生成
        fixture = TestBed.createComponent(UseComponent);
        comp = fixture.componentInstance;
        de = fixture.debugElement.query(By.css('li'));
    });

    it('<li>要素のテキストを確認', () => {
        expect(spy.calls.any()).toEqual(true);  // 実際に呼び出されたかを検証
        expect(spy.calls.count()).toEqual(1);   // 何回呼び出されたかを検証
        fixture.detectChanges();
        expect(de.nativeElement.textContent).toEqual('UseService : ' + current.toLocaleString());
    });
});
