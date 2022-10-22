import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'grep'
})
export class GrepPipe implements PipeTransform {
    transform(values: any[], callback: (item: any) => boolean) {
        // 加工対象の値が配列でない場合、もとの値をそのまま返す
        if(!Array.isArray(values)){
            return values;
        }

        // 加工対象の配列を走査＆コールバック関数でチェック
        return values.filter(callback);
    }
}
