import {Component, OnDestroy, OnInit} from '@angular/core';
import {MatBottomSheet, MatBottomSheetRef} from '@angular/material/bottom-sheet';
import {MyEvent, StateService} from '../../service/state.service';
import {FormControl, FormGroup} from '@angular/forms';
import {ScrollService} from '../../service/scroll.service';
import {Catch} from '../../class/log.class';


@Component({
    selector: 'app-setting',
    templateUrl: './setting.component.html',
    styleUrls: ['./setting.component.css']
})


export class SettingComponent implements OnInit {
    toggleButtonGroup;
    labels;
    isUpdate;
    subscription;
    constructor(
        public stateService: StateService,
        public scrollService: ScrollService,
        private bottomSheetRef: MatBottomSheetRef<SettingComponent>) {

    }

    @Catch()
    ngOnInit() {
        // フォームグループを生成
        this.toggleButtonGroup = new FormGroup({});

        let setting = this.stateService.state.setting;

        console.dir(setting);
        this.labels = Object.values(setting);
        //フォームコントロールを生成してフォームグループに登録}
        this.labels.forEach(label => {
            this.toggleButtonGroup.addControl(label.name, new FormControl(label.value));
        });

        // 選択の変更検知関数を登録
        this.toggleButtonGroup.valueChanges.subscribe(v => this.update(v));

    }

    @Catch()
    update(data) {
        let setting = this.stateService.state.setting;
        console.dir(setting);
        let buttons = this.toggleButtonGroup.value;
        Object.keys(buttons).forEach(
            key => {
                setting[key].value = buttons[key];
            });
        console.dir(buttons);
        //
        // if(!buttons[0]){
        //   this.scrollService.ADD_LOAD_SIZE=10000;
        //   console.log("@@@ADD_LOAD_SIZE="+this.scrollService.ADD_LOAD_SIZE);
        // }
        // if(!buttons[1]){
        //   this.scrollService.PREFETCH_SIZE=0;
        //   console.log("@@@PREFETCH_SIZE="+this.scrollService.PREFETCH_SIZE);
        // }

    }


    @Catch()
    close() {
        this.bottomSheetRef.dismiss();
    }
}

