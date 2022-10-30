import { Component } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { ComponentFixture, TestBed } from '@angular/core/testing';
import { By } from '@angular/platform-browser';
import { DebugElement } from '@angular/core';

import { EditComponent } from './edit.component';
import { Book } from './book';

// <edit-book>コンポーネントをホストするためのコンポーネントを準備
@Component({
    selector: 'my-app',
    template: `
        <edit-book [item]="selected" (edited)="onedited($event)"></edit-book>
    `
})
export class EditTestComponent {
    // 選択された書籍情報
    selected = <Book> {
        isbn: '978-4-7741-8411-1',
        title: '改訂新版JavaScript本格入門',
        price: 2980,
        publisher: '技術評論社',
    };

    updated: Book = new Book;

    //editedイベントが発生した時に、更新対象の書籍情報をupdatedプロパティに反映
    onedited(book: Book){
        this.updated = book;
    }   
}

// テストスクリプト本体
describe('EditComponent', () => {
    let de: DebugElement;
    let comp: EditTestComponent;
    let fixture: ComponentFixture<EditTestComponent>;

    // テストの前準備
    beforeEach(() => {
        TestBed.configureTestingModule({
            imports: [ FormsModule ],
            declarations: [ EditComponent, EditTestComponent ]
        });

        // ホストコンポーネントをインスタンス化
        fixture = TestBed.createComponent(EditTestComponent);
        comp = fixture.componentInstance;
        fixture.detectChanges();
    });

    // 入力プロパティが渡された内容が反映されているかを検証
    it('ISBNコードの確認', () => {
        let de = fixture.debugElement.query(By.css('#isbn'));
        expect(de.nativeElement.textContent).toEqual(comp.selected.isbn);
    });

    // サブミット時にeditedイベントが発生するか
    it('editedイベントの確認', () => {
        let de = fixture.debugElement.query(By.css('form'));
        de.triggerEventHandler('ngSubmit', null);
        fixture.detectChanges();
        expect(comp.updated).toEqual(comp.selected);
    });
});
