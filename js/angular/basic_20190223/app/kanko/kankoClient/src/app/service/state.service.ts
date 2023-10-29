import {HostListener, Injectable} from '@angular/core';
import {Subject, Subscription, Observable} from 'rxjs';
import {map, filter} from 'rxjs/operators';
import {AREA_FORM, GENRE_FORM} from '../app.config';
import {MatSnackBar, MatSnackBarVerticalPosition} from '@angular/material/snack-bar';
import {Catch} from '../class/log.class';

export enum MyEvent {
    READY_BUFFER, CLOSE, OFFLINE, ONLINE, DB_UPDATE, RESIZE
}

@Injectable()
export class StateService {

    state = {
        selectedKeys: [] as string[],
        genres: [] as string[],
        areas: [] as string[],
        setting: {
            // scroll: {name: 'scroll', label: '無限スクロール', value: true},
            modern: {name: 'modern', label: 'ブラウザで分散処理', value: true},
            prefetch: {name: 'prefetch', label: 'データ先読み表示(prefetch)', value: true}
            // install: {name: 'install', label: 'アプリ保存', value: true}
        }
    };
    isSync:false;
    favoriteSync: null;
    downloadRep: null;
    docCount: number;
    // docCountStr: string;
    subject = new Subject<MyEvent>();

    constructor(private snackBar: MatSnackBar) {
    }

    @Catch()
    saveState() {

        // this.state.path=location.pathname;
        // let jsonState = JSON.stringify(this.state);
        // localStorage.setItem('state', jsonState);
        // console.log('state保存:' + jsonState);
    }

    @Catch()
    restoreState() {
        // let ret = localStorage.getItem('state');
        // console.dir(ret);
        // if (ret) {
        //     this.state = {...this.state, ...JSON.parse(ret)};
        // }
        // console.dir(this.state);
    }

    @HostListener('window:online', ['$event'])
    onOnline() {
        this.publish(MyEvent.ONLINE);
        console.log('@@@オンライン状態に変化');
    }

    @HostListener('window:offline', ['$event'])
    onOffline() {
        this.publish(MyEvent.OFFLINE);
        console.log('@@@オフライン状態に変化');
    }


    //イベント受信の登録
    subscribe(event: MyEvent, cb: () => void): Subscription {
        return this.subject.pipe(
            filter(e => e === event)
        ).subscribe(cb);

    }

    //イベントの発行
    publish(name: MyEvent) {
        this.subject.next(name);
        console.log('@@@イベントPublish:' + MyEvent[name]);
    }

    openSnackBar(msg: string, duration?: number) {
        let option = {
            duration: duration || 30000,
            verticalPosition: 'top' as MatSnackBarVerticalPosition
        };
        setTimeout(() => {
            this.snackBar.open(msg, '×閉じる', option);
        });
    }

}

