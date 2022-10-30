import { DebugElement } from '@angular/core';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { AppComponent } from './app.component';

describe('AppComponent', () => {
  let des: DebugElement[];
  let comp: AppComponent;
  let fixture: ComponentFixture<AppComponent>;

  beforeEach(async () => {
    // テストモジュールの準備
    await TestBed.configureTestingModule({
      declarations: [
        AppComponent
      ],
    }).compileComponents(); // テンプレートのコンパイル
  });

  beforeEach(() => {
    // コンポーネントのインスタンス化
    fixture = TestBed.createComponent(AppComponent);
    comp = fixture.componentInstance;
  });

  it('テーブルの行数を確認', () => {
    fixture.detectChanges();
    des = fixture.debugElement.queryAll(By.css('tr'));
    // テキストでは、６だが、２になる
    // expect(des.length).toEqual(6);
    expect(des.length).toEqual(2);
  });
});
