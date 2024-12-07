import { Component, ViewChild } from '@angular/core';
import { DebugElement } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';

import { EditComponent } from './edit.component';
import { Book } from './book';

describe('Input/Output Component', () => {
    let sample: Book;
    let comp: EditComponent;
    let fixture: ComponentFixture<EditComponent>;

    beforeEach(() => {
        // テストモジュールの準備
        TestBed.configureTestingModule({
    imports: [FormsModule, EditComponent]
})

        // コンポーネントをインスタンス化
        fixture = TestBed.createComponent(EditComponent);
        comp = fixture.componentInstance;
        sample = <Book> {
            isbn: '978-4-7741-8411-1',
            title: '改訂新版JavaScript本格入門',
            price: 2980,
            publisher: '技術評論社',
        };
        comp.item = sample;
        fixture.detectChanges();
    });

    // itemプロパティの値がテンプレートに反映されているかを検証
    it('IDBNコードの確認', () => {
        let de = fixture.debugElement.query(By.css('#isbn'));
        expect(de.nativeElement.textContent).toEqual(sample.isbn);
    });

    // editedイベントによって値が正しく引き渡されているかを検証
    it('editedイベントの確認', () => {
        let updated: Book = new Book;
        let de = fixture.debugElement.query(By.css('form'));

        // editedイベントを受けた時の処理
        comp.edited.subscribe((b: Book) => {
            updated = b;
        });

        // ngSubmitイベントを発生
        de.triggerEventHandler('ngSubmit', null);

        // 変数updatedとitemプロパティの値を比較
        expect(updated).toBe(comp.item);
    });
});
