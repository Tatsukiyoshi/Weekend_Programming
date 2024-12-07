import { NgModule } from "@angular/core";
import { CommonModule } from "@angular/common"
import { FormsModule } from "@angular/forms";

import { DetailsComponent } from "./details.component";
import { EditComponent } from "./edit.component";

@NgModule({
    imports: [ CommonModule, FormsModule, DetailsComponent, EditComponent],
    //declarations: [ DetailsComponent, EditComponent ],
    exports: [ DetailsComponent, EditComponent ]
})
export class CoopModule { }
