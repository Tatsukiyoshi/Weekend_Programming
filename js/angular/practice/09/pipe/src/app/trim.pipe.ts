import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'trim'
})
export class TrimPipe implements PipeTransform {
    transform(value: string) {
        if(typeof value !== 'string'){
            return value;
        }

        return value.trim();
    }
}
