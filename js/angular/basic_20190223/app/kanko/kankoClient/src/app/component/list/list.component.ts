import {ChangeDetectorRef, Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {DataService} from '../../service/data.service';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {DetailDialogComponent} from '../detail/detail.dialog';
import {ScrollService} from '../../service/scroll.service';
import {MyEvent, StateService} from '../../service/state.service';
import {Subscription} from 'rxjs';
import {Catch} from '../../class/log.class';

@Component({
    selector: 'app-list',
    templateUrl: './list.component.html',
    styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit, OnDestroy {

    // @ViewChild("dataList") dataList: ElementRef;
    subscription = [];


    constructor(
        public scrollService: ScrollService,
        private router: Router,
        public dialog: MatDialog,
        public dataService: DataService,
        public stateService: StateService,
        private changeDetectorRef: ChangeDetectorRef,
    ) {
        this.subscription.push(
            this.stateService.subscribe
            (MyEvent.DB_UPDATE, (() => {
                this.refresh();
            })));
        this.subscription.push(
            this.stateService.subscribe
            (MyEvent.RESIZE, (() => {
                this.resize();
            })));
    }

    @Catch()
    ngOnInit() {
        this.init();
    }

    //初期表示データ取得
    @Catch()
    async init() {
        await this.scrollService.init();
    }


    resize() {
        this.scrollService.resize();
    }

    @Catch()
    async refresh() {
        let hash = await this.dataService.getFavoriteId();
        this.scrollService.docs.forEach(doc => doc.isFavorite = !!hash[doc._id]);
        this.changeDetectorRef.detectChanges();
        console.log('@@@ 同期を表示に反映');
    }

    onScroll(event) {
        this.scrollService.update();
    }

    @Catch()
    clickFavoriteButton(doc) {
        // try {
        let res = doc.isFavorite ? this.dataService.deleteFavorite(doc) : this.dataService.saveFavorite(doc);
        doc.isFavorite = !doc.isFavorite;

        // } catch (error) {
        //   throw new Error("お気に入り更新失敗" + error.message);
        // }

    }

    @Catch()
    trackByFn(index, doc) {
        return doc.serial; // or item.id
    }

    @Catch()
    async deleteDoc(doc) {
        await this.dataService.deleteFavorite(doc);
    }

    @Catch()
    async openDialog(doc) {
        this.dialog.open(DetailDialogComponent,
            {
                data: {doc, docs: this.scrollService.docs},
                closeOnNavigation: true,
                hasBackdrop: true,
                disableClose: true
            });
    }

    ngOnDestroy() {
        // this.stateService.state.listMode=/false;
        this.scrollService.clearDoc();
        this.subscription.forEach(sub => sub.unsubscribe());
    }

}

