// ====================
// アプリの状態(State)クラス
// ====================

import {Alarm} from './alarm.class';
import {Catch} from './log.class';
// export interface StateData {
//     alarmList: Alarm[];       // アラームの配列
//     theme: string;            // 現在のテーマ（配色）
//     isEnablePush: boolean;    // Push通知機能ON?
// }


// Stateクラスの定義
export class State {
    alarmList: Alarm[];       // アラームの配列
    theme: string;            // 現在のテーマ（配色）
    isEnablePush: boolean;    // Push通知機能ON?
// stateData:StateData={};
    // コンストラクタ
    constructor(isRestore = true) {
        this.alarmList = [];
        this.isEnablePush = false;
        this.theme = 'deeppurple-amber';
        // 復元データのインポート
        if (isRestore) {
            this.onRestore();
        }

    }


    // アプリ起動時に状態の復元
    @Catch()
    onRestore() {
        // json文字列の取得
        const json = localStorage.getItem('state');
        if (json) {
            // StateData型のオブジェクトとして復元
            const obj: any = JSON.parse(json);
            // Stateオブジェクトのプロパティを上書き
            this.isEnablePush = obj.isEnablePush;
            this.theme = obj.theme;
            // DeepコピーのためObject.assingで処理できないオブジェクトの配列は
            // オブジェクト１つにばらして上書きコピー
            if (obj.alarmList && (obj.alarmList.length > 0)) {
                this.alarmList = obj.alarmList.map(
                    alarmData => Object.assign(new Alarm(alarmData))
                );
            }
            // 前回終了時のテーマを復元
            this.changeTheme(this.theme || 'deeppurple-amber');
        }
    }

    // ブラウザが閉じる直前に状態の保存とリソースの開放
    @Catch()
    onBeforeUnload() {
        // 状態の保存
        this.save();
        // 未完了タイマーの削除
        this.alarmList.forEach(alarm => alarm.cancelTimer());
    }

    // テーマを表示に反映(index.htmlのテーマファイル指定記述を書き換え）
    @Catch()
    changeTheme(name = 'deeppurple-amber') {
        document.getElementById('myTheme').setAttribute(
            'href', 'assets/css/' + name + '.css');
    }

    // ローカルアラームの登録
    @Catch()
    addLocalAlarm(alarm: Alarm, timeup) {
        // アラーム一覧登録とタイマー開始
        alarm.startTimer(timeup);
        this.alarmList.push(alarm);
        this.sortAlarmList();
    }

    // ローカルアラーム削除
    @Catch()
    async deleteLocalAlarm(index: number) {
        const alarm = this.alarmList[index];
        this.deleteAlarmByIndex(index);
    }

    // 設定時刻経過済みのアラームを削除
    @Catch()
    cleanupAlarmList(): Alarm[] {
        if (this.alarmList.length === 0) {
            return;
        }
        const newList = this.alarmList.filter(item => {
            return (item.alarmTimestamp - Date.now() > 0);
        });
        this.alarmList = newList.map(item => new Alarm(item));
        this.sortAlarmList();
    }

    // リストからAlarmオブジェクトを指定して削除
    @Catch()
    deleteAlarm(alarm: Alarm) {
        const index = this.getAlarmIndex(alarm);
        if (index) {
            this.deleteAlarmByIndex(index);
        }
    }


    // リストのindexを指定してアラームの削除
    @Catch()
    deleteAlarmByIndex(index: number) {
        if (this.alarmList.length === 0) {
            return;
        }
        const alarm = this.alarmList[index];
        alarm.cancelTimer();
        this.alarmList.splice(index, 1);
        this.sortAlarmList();
    }

    // 登録されているアラームの配列インデックスを取得
    @Catch()
    getAlarmIndex(tmpAlarm: Alarm): number {
        for (let i = 0; i < this.alarmList.length; i++) {
            if (tmpAlarm.id === this.alarmList[i].id) {
                return i;
            }
        }
    }

    // ========private method===========

    // 状態保存
    @Catch()
    private save() {
        let json;
        const stateData = {
            alarmList: this.alarmList,       // アラームの配列
            theme: this.theme,            // 現在のテーマ（配色）
            isEnablePush: this.isEnablePush    // Push通知機能ON?
        };
        json = JSON.stringify(stateData);
        localStorage.setItem('state', json);
    }


    // アラーム一覧を設定時刻の昇順に並べ替え
    @Catch()
    private sortAlarmList() {
        if (this.alarmList.length > 1) {
            this.alarmList.sort(
                (a, b) => a.alarmTimestamp - b.alarmTimestamp
            );
        }
    }

}
