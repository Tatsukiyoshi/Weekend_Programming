import { DebugElement, NO_ERRORS_SCHEMA } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { RouterTestingModule } from '@angular/router/testing';
import { By } from '@angular/platform-browser';

import { AppComponent } from './app.component';

describe('AppComponent', () => {
  let des: DebugElement[];
  let comp: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async () => {
    // テストモジュールを準備
    await TestBed.configureTestingModule({
    imports: [
        RouterTestingModule,
        AppComponent
    ],
    schemas: [
        NO_ERRORS_SCHEMA
    ]
}).compileComponents();

    // コンポーネントをインスタンス化
    fixture = TestBed.createComponent(AppComponent);
    comp = fixture.componentInstance;
    des = fixture.debugElement.queryAll(By.css('a'));
  });

  // アンカータグが３個あることを確認（テキストサンプルコードのみの場合）
  /*
  it('<a>要素の個数を確認', () => {
    fixture.detectChanges();
    expect(des.length).toEqual(3);
  });
  */

  // アンカータグが８個あることを確認［８章のサンプルコードをまとめた関係から］
  it('<a>要素の個数を確認', () => {
    fixture.detectChanges();
    expect(des.length).toEqual(8);
  });
});
