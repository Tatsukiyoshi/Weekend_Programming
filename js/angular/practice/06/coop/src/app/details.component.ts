import { Component, Input } from '@angular/core';
import { Book } from './book';

@Component({
    selector: 'detail-book',
    templateUrl: './details.component.html',
})

export class DetailsComponent {
    @Input()
    item: Book = new Book;
}
