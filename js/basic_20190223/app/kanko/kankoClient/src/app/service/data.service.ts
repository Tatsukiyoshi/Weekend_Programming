import {Injectable} from '@angular/core';
import {Router} from '@angular/router';
import {DbService} from './db.service';
import {MyEvent, StateService} from './state.service';
import {COUNT_TABLE} from '../app.countTable';
import {MAX_FAVORITE, REMOTEDB_URL} from '../app.config';
import {MatSnackBar, MatSnackBarVerticalPosition} from '@angular/material';
import {HttpClient} from '@angular/common/http';
import {Catch} from '../class/log.class';

// アプリの初期化、終了処理
// 画面共通の処理（イベント)
@Injectable()
export class DataService {

    COUNT_TABLE: { [key: string]: number } = COUNT_TABLE;

    constructor(
        private router: Router,
        private dbService: DbService,
        private stateService: StateService,
    ) {
    }

    @Catch()
    async init() {
        await this.dbService.start();
    }

    catch(error) {
        this.stateService.openSnackBar('データベース初期化失敗' + error.message, 10000);
    }

    //検索結果件数（検索画面と結果画面の両方で表示
    @Catch()
    countDoc(keys: string[]) {
        this.stateService.docCount = null;
        keys.forEach(key => {
            this.stateService.docCount += this.COUNT_TABLE[key];
        });
    }

    @Catch()
    async getDocs(query: any) {
        return await this.dbService.getDocs(query);
    }


    @Catch()
    async getFavoriteId() {
        return await this.dbService.getFavoriteId();
    }

    @Catch()
    async getFavorite() {
        return await this.dbService.getFavorite();
    }

    @Catch()
    async saveFavorite(doc, blob = null) {
        return this.dbService.saveFavorite(doc, blob);
    }

    @Catch()
    async deleteFavorite(doc) {
        return await this.dbService.deleteFavorite(doc);
    }

    //写真の取得
    @Catch()
    async getPhoto(doc, isRemote: boolean) {
        return await this.dbService.getPhoto(doc._id, true);
    }

}
