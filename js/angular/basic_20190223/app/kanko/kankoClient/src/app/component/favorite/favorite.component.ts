import {ChangeDetectorRef, Component, ElementRef, OnDestroy, OnInit, ViewChild} from '@angular/core';
import {DataService} from '../../service/data.service';
import {Router} from '@angular/router';
import {MatDialog} from '@angular/material/dialog';
import {DetailDialogComponent} from '../detail/detail.dialog';
import {MyEvent, StateService} from '../../service/state.service';
import {Subscription} from 'rxjs';
import * as blobUtil from 'blob-util';
import {Catch} from '../../class/log.class';

@Component({
    selector: 'app-favorite',
    templateUrl: './favorite.component.html',
    styleUrls: ['./favorite.component.css']
})
export class FavoriteComponent implements OnInit, OnDestroy {
    docs;
    subscription: Subscription;
    dialogRef;

    constructor(
        private router: Router,
        public dialog: MatDialog,
        public dataService: DataService,
        public stateService: StateService,
        private changeDetectorRef: ChangeDetectorRef,
    ) {
        this.subscription = this.stateService.subscribe(
            MyEvent.DB_UPDATE, (() => {
                this.refresh();
            }));
    }

    @Catch()
    ngOnInit() {
        this.init();
    }

//初期表示データ取得
    @Catch()
    async init() {
        // try {
        this.docs = await this.dataService.getFavorite();
        console.dir(this.docs);
        // } catch (error) {
        //   throw new Error("お気に入りデータの取得失敗" + error.message);
        // }
    }

    @Catch()
    async refresh() {
        // this.stateService.openSnackBar("favoriteDbが更新されました",1000);
        await this.init();
        this.changeDetectorRef.detectChanges();
        console.log('@@@　 同期を表示に反映');
    }


    trackByFn(index, doc) {
        return doc.serial; // or item.id
    }

//写真の表示
    @Catch()
    async showPhoto(doc) {
        try {
            let blob = await this.dataService.getPhoto(doc, false);
            return await blobUtil.blobToDataURL(blob);
        } catch (error) {
            this.stateService.openSnackBar('写真の表示失敗' + error.message);
        }
    }

    @Catch()
    clickFavoriteButton(doc) {
        try {
            let res = doc.isFavorite ? this.dataService.deleteFavorite(doc) : this.dataService.saveFavorite(doc);
            doc.isFavorite = !doc.isFavorite;

        } catch (error) {
            throw new Error('お気に入り更新失敗' + error.message);
        }

    }

    @Catch()
    async deleteDoc(doc) {
        // try {
        await this.dataService.deleteFavorite(doc);
        await this.refresh();
        // } catch (error) {
        //   throw new Error("お気に入りの削除に失敗" + error.message);
        // }
    }

    @Catch()
    async openDialog(doc) {
        this.dialogRef = this.dialog.open(DetailDialogComponent,
            {
                data: {doc: doc, docs: this.docs}
            });
        this.dialogRef.docs = this.docs;
    }

    @Catch()
    ngOnDestroy() {
        this.subscription.unsubscribe();
    }

}
