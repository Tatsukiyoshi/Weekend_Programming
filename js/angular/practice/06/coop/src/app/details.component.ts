import { Component, Input } from '@angular/core';
import { Book } from './book';
import { CommonModule } from '@angular/common';

@Component({
    imports: [CommonModule],
    selector: 'detail-book',
    templateUrl: './details.component.html',
})

export class DetailsComponent {
    @Input()
    item: Book = new Book;
}
