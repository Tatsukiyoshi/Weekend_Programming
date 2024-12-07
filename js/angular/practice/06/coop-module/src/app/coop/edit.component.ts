import { Component, EventEmitter, Input, Output } from '@angular/core';
import { Book } from '../book';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
    imports: [CommonModule, FormsModule],
    selector: 'edit-book',
    templateUrl: './edit.component.html',
})

export class EditComponent {
    @Input()
    item: Book = new Book;
    @Output() edited = new EventEmitter<Book>();

    // サブミット時にeditedイベントを発生（$eventにはBookオブジェクトを代入）
    onsubmit(){
        this.edited.emit(this.item);
    }
}
