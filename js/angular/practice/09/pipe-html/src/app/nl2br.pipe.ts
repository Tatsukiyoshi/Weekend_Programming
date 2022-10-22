import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'nl2br'
})
export class Nl2brPipe implements PipeTransform {
    transform(value: string) {
        if(typeof value !== 'string'){
            return value;
        }

        return value.replace(/\r?\n/g, '<br />');
    }
}
