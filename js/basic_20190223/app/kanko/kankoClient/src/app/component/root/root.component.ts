import {ChangeDetectorRef, Component, HostListener, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {DataService} from '../../service/data.service';
import {Router} from '@angular/router';
import {MyEvent, StateService} from '../../service/state.service';
import {ListComponent} from '../list/list.component';
import {ScrollService} from '../../service/scroll.service';
import {Subscription} from 'rxjs';
import {MatBottomSheet, MatProgressSpinner} from '@angular/material';
import {SettingComponent} from '../setting/setting.component';
import {Catch} from '../../class/log.class';

// import {LIST_MODE} from "../app.config";
// import {UtilityService} from "../service/utility.service";

@Component({
    selector: 'app-root',
    templateUrl: './root.component.html',
    styleUrls: ['./root.component.css']
})
export class RootComponent implements OnInit, OnDestroy {
    @ViewChild('outret') componentRef: Component;
    //isWati=tureの間はデータバインドを待機
    isWait = true;
    subscription: Subscription;
    isUpdate = false;
    isQue = false;

    constructor(
        public router: Router,
        public dataService: DataService,
        public stateService: StateService,
        public scrollService: ScrollService,
        private changeDetectorRef: ChangeDetectorRef,
        private bottomSheet: MatBottomSheet
    ) {
        this.subscription = this.stateService.subscribe(
            MyEvent.DB_UPDATE, () => {
                this.isUpdate = true;
                setTimeout(() => {
                    this.isUpdate = false;
                }, 2000);
            });
    };


    //画面表示前の初期化
    @Catch()
    ngOnInit() {
        this.init();
    }

    async init() {
        //設定情報読み込み
        this.stateService.restoreState();

        let res = await this.dataService.init();

        this.isWait = false;
        this.router.navigate(['/search']);
    }

    async favorite() {
        this.router.navigate(['/favorite']);
    }

    //条件を変えて検索メニュー
    search() {
        this.router.navigate(['/search']);
    }

    //新規検索メニュー
    newSearch() {
        this.stateService.state.genres = [];
        this.stateService.state.areas = [];
        this.stateService.state.selectedKeys = [];
        this.router.navigate(['/search']);
    }

    //設定メニュー
    setting() {
        this.bottomSheet.open(SettingComponent);
    }


    //マウスクリックイベント
    clickOp(e: Event) {
        if (!this.stateService.state.setting.modern.value) {
            console.log('@@@ mouse click');
            this.isQue = true;
            setTimeout(() => {
                this.isQue = false;
            }, 2000);
        }
    }

    //ブラウザが閉じるイベント
    @HostListener('window:beforeunload', ['$event'])
    beforeUnload(e: Event) {
        console.log('@@@before unload');
        this.stateService.saveState();
    }

    //スマートフォンで画面の縦横回転
    resize(e: Event) {
        console.log('@@@ window resize');
        this.stateService.publish(MyEvent.RESIZE);
    }

    ngOnDestroy() {
        this.subscription.unsubscribe();
    }

}
