import { Injectable } from "@angular/core";

@Injectable()
export class OverService {
    id = 'Normal';
    show() {
        return `${this.id} Service`;
    }
}

@Injectable()
export class SpecialOverService extends OverService {
    override id = 'Special';
}
