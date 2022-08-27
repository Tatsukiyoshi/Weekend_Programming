import {ChangeDetectorRef, Component, Inject, OnDestroy, OnInit} from '@angular/core';
import {MAT_DIALOG_DATA, MatDialogRef} from '@angular/material';
import {DomSanitizer} from '@angular/platform-browser';
import {DataService} from '../../service/data.service';
import {MyEvent, StateService} from '../../service/state.service';
import {MAX_FAVORITE, REMOTEDB_URL} from '../../app.config';
import * as blobUtil from 'blob-util';
import {HttpClient} from '@angular/common/http';
import {DbService} from '../../service/db.service';
import {Router} from '@angular/router';
import {Catch} from '../../class/log.class';

@Component({
    selector: 'app-detail-dialog',
    templateUrl: 'detail.dialog.html',
    styleUrls: ['detail.dialog.css']
})
export class DetailDialogComponent implements OnInit {

    doc: any;
    imgStr = '';
    blob;
    docs;
    isStart = false;
    isEnd = false;
    isMAX = false;

    constructor(
        public dialogRef: MatDialogRef<DetailDialogComponent>,
        public dataService: DataService,
        @Inject(MAT_DIALOG_DATA) public data: any,
        public   stateService: StateService,
        // public   scrollService: ScrollService,
        private changeDetectorRef: ChangeDetectorRef,
        private router: Router,
    ) {
        this.doc = data.doc;
        this.docs = data.docs;
    }

    ngOnInit() {
        this.init();
    }

    //初期化
    @Catch()
    async init() {
        await this.dialogSize();
        await this.checkPos();
        await this.showPhoto();
    }

    @Catch()
    dialogSize() {
        let height = (innerHeight / innerWidth < 1.6) ? (innerHeight - 20) : (innerWidth - 20) * 1.6;
        let width = height / 1.6;
        this.dialogRef.updateSize(width + 'px', height + 'px');
    }

    //写真の表示
    @Catch()
    async showPhoto() {
        try {
            this.blob = await this.dataService.getPhoto(this.doc, !(this.doc.isFavorite));
            this.imgStr = await blobUtil.blobToDataURL(this.blob);
        } catch (error) {
            this.stateService.openSnackBar('写真の表示失敗' + error.message);
        }
    }

    //表示データの終端チェック
    @Catch()
    checkPos() {
        let currentPage = this.doc.serial;
        this.isStart = (currentPage === 1);
        this.isEnd = (currentPage === this.docs.length);
    }


    //前または次ボタン選択時の処理
    @Catch()
    movePage(num: number) {
        let nextPage = this.doc.serial + num;
        if (nextPage < 1 || nextPage > this.docs.length) {
            return;
        }
        this.doc = this.docs[nextPage - 1];
        this.showPhoto();
    }

//登録と解除ボタンの選択
    @Catch()
    async clickFavoriteButton(doc) {
        doc.isFavorite = !doc.isFavorite;
        let res;
        // try {
        if (doc.isFavorite) {
            res = await this.dataService.saveFavorite(doc, this.blob);
        } else {

            res = await this.dataService.deleteFavorite(doc);
        }
        this.close();
        console.dir(res);
        // } catch (error) {
        //   this.stateService.openSnackBar("登録または解除の失敗" + error.message);
        // }
    }


    //閉じるボタン選択時の処理
    @Catch()
    async close() {
        this.dialogRef.close();
    }


    // ngOnDestroy() {
    // this.stateService.state.listMode=/false;
    //   this.scrollService.clearDoc();
    // }
}
