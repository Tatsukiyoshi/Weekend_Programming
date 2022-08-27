import {ElementRef, Injectable} from '@angular/core';
import {DataService} from './data.service';
import {MyEvent, StateService} from './state.service';
import {Catch} from '../class/log.class';


@Injectable()
export class ScrollService {

    isWait = true;
    PREFETCH_SIZE = 10;
    ADD_LOAD_SIZE = 30;
    ROW_HEIGHT = 169;
    WINDOW_HEIGHT;
    CONTENTS_HEIGHT;
    SCROLL_OFFSET;
    THRESHOLD;
    SCROLL_WAIT = 100;//msec
    start = 1;
    end;
    pos;
    posY;
    docs = [];
    nextDocs = [];
    isEnd = false;
    state;


    constructor(
        private dataService: DataService,
        private stateService: StateService,
    ) {

    }


    @Catch()
    async prefetch() {
        if (!this.stateService.state.setting.prefetch.value) return;
        if (!this.PREFETCH_SIZE) return;
        // try {
        this.clearDoc();
        this.docs = await this.dataService.getDocs({skip: 0, limit: this.PREFETCH_SIZE}) || [];
        console.log('@@@ Prefetch完了');
        // } catch (error) {
        //   throw new Error("" + error.message);
        // }
    }

    @Catch()
    async init() {
        // try {
        if (!this.stateService.state.setting.prefetch.value) {
            this.clearDoc();
            this.docs = await this.dataService.getDocs({
                skip: 0,
                limit: 2000
            });
            await this.initScroll();
            this.isWait = true;
            return;
        }


        if (this.PREFETCH_SIZE) {
            await this.initScroll();
            await this.setBuffer();
            this.isWait = true;
        } else {
            this.clearDoc();
            await this.setBuffer();
            await this.initScroll();
            this.isWait = true;
        }
        // this.stateService.publish(MyEvent.DB_UPDATE);
        // } catch (error) {
        //   throw new Error("" + error.message);
        // }
    }


    stop() {
        this.isWait = true;
    }

    //初期バッファ設定
    @Catch()
    async setBuffer() {

        this.setConst();
        let query = {
            skip: this.PREFETCH_SIZE,
            limit: (this.ADD_LOAD_SIZE * 2 - this.PREFETCH_SIZE),
            include_docs: true
        };
        let res = await this.dataService.getDocs(query);
        this.docs = this.docs.concat(res).slice() || [];
        if (this.docs && this.PREFETCH_SIZE) {
            delete this.docs[this.docs.length - 1].isEnd;
        }

        // if (this.docs&&this.docs.length){
        this.updatePos(this.docs);
        this.checkEnd(this.docs);
        this.isWait = false;
        await this.createNextBuffer();
        return;
        // }
        // throw new Error("No Data");
    }

    @Catch()
    resize() {
        this.setConst();
    }

    @Catch()
    private setConst() {
        //画面表示域の高さ
        this.WINDOW_HEIGHT = innerHeight;
        //リスト全体の高さ
        this.CONTENTS_HEIGHT = this.ROW_HEIGHT * this.docs.length;
        //スクロールオフセット
        this.SCROLL_OFFSET = this.ROW_HEIGHT * this.ADD_LOAD_SIZE;
        //データ追加ロードのしきい値
        this.THRESHOLD = this.SCROLL_OFFSET / 2;
    }

    @Catch()
    update() {
        let posY = scrollY;
        this.setConst();

        //表示先頭のデータ番号
        // this.pos = Math.floor(this.start + posY / this.ROW_HEIGHT);
        // this.stateService.state.docCount = this.pos + "/" + this.stateService.state.docCount + "件目";

        if (this.isWait || this.isEnd) {
            // return;
        }

        //下スクロール可能サイズ
        let bottomScrollMargin = this.CONTENTS_HEIGHT - this.WINDOW_HEIGHT - posY;
        //log
        console.log('posY=%d,magin=%d,threshold=%d,listH=%d',
            posY, bottomScrollMargin, this.THRESHOLD, bottomScrollMargin + posY + this.WINDOW_HEIGHT);

        //スクロール終端で強制反転
        if (bottomScrollMargin < this.ROW_HEIGHT) {
            console.log('スクロール強制反転');
            this.move(scrollY - this.ROW_HEIGHT, 0, null);
        }

        //バッファのリフレッシュ
        if (bottomScrollMargin < this.THRESHOLD) {
            console.log('バッファ更新要求');
            this.refreshBuffer();
        }
    }

    @Catch()
    checkEnd(docs: any) {
        this.isEnd = docs.length < (this.ADD_LOAD_SIZE * 2);
        this.isWait = this.isEnd;
    }

    @Catch()
    async refreshBuffer() {
        if (!this.nextDocs) {
            return;
        }
        console.log('バッファ更新処理開始');
        this.move(scrollY - this.SCROLL_OFFSET, this.SCROLL_WAIT, null);
        this.docs = this.nextDocs || [];
        this.updatePos(this.docs);
        this.checkEnd(this.docs);
        this.nextDocs = null;
        console.log('バッファ更新完了:%d～%d件目', this.start, this.end);
        await this.createNextBuffer();
        return true;
    }

    @Catch()
    initScroll() {
        this.move(this.posY, this.SCROLL_WAIT, null);
    }

    @Catch()
    move(posY: number, wait: number, callback: any) {
        setTimeout(() => {
            scroll(0, posY);
            if (callback) {
                callback();
            }
        }, wait);
    }

    @Catch()
    updatePos(docs: any[]) {
        this.start = docs[0].serial; //1から採番
        this.end = this.start + (docs.length - 1);
        this.pos = this.pos || 1;
        this.posY = this.posY || 0;
    }

    @Catch()
    async createNextBuffer() {
        if (this.isEnd) {
            return;
        }
        console.log('追加データ受信開始:%d～%d件目', this.end + 1, this.end + this.ADD_LOAD_SIZE);
        let docs = await this.dataService.getDocs({
            skip: this.end,
            limit: this.ADD_LOAD_SIZE
        });
        if (!docs) {
            return [];
        }

        this.nextDocs = this.docs.concat(docs).slice(this.ADD_LOAD_SIZE) || [];
        console.log('次バッファ準備完了:%d～%d',
            this.nextDocs[0].serial,
            this.nextDocs[this.nextDocs.length - 1].serial);
    }

    @Catch()
    clearDoc() {
        this.docs = null;
        this.nextDocs = null;
    }

}
