import { Directive } from "@angular/core";
import { AbstractControl, NG_VALIDATORS, ValidationErrors, Validator } from "@angular/forms";

@Directive({
    selector: '[myZip][ngModel]',
    providers: [
        {provide: NG_VALIDATORS, useExisting: ZipValidator, multi: true }
    ]
})
export class ZipValidator implements Validator {
    validate(control: AbstractControl): {[key: string]: any } | null {
        return /^[0-9]{3}-[0-9]{4}$/.test(control.value) ? null : { zip: true };           
    }
}
