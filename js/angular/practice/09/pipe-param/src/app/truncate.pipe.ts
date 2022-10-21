import { Pipe, PipeTransform } from "@angular/core";

@Pipe({
    name: 'truncate'
})
export class TruncatePipe implements PipeTransform {
    transform(value: string, length: number = 50, omission: string = '...') {
        // 加工対象の値が文字列でない場合、もとの値をそのまま返す
        if(typeof value !== 'string'){
            return value;
        }
        // 文字列長が指定文字数（length）以下の場合、もとの値をそのまま返す
        if(value.length <= length){
            return value;
        } else {
            // 指定文字数より長い場合は切り捨て、末尾文字（omission）を追加
            return value.substring(0, length) + omission;
        }        
    }
}
