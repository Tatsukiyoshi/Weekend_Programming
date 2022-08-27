//====================
// Alermクラス
//====================
import {Catch} from "./log.class";

export class Alarm {

  id: number;              //unix timestampを識別IDに利用(単位msec)
  timerValue: number;      //スライダーでセットした待ち時間(単位分)
  alarmTimestamp: number;  //アラーム時刻のunix timestamp(単位msec)
  title: string;           //アラーム名
  isPush: boolean;         //Push通知を行うか？
  timer: number;           //setTimeoutの戻り値

  //コンストラクタ
  constructor(dataObj?: Partial<Alarm>) {
    this.id = Date.now();
    this.timerValue = 0;
    this.alarmTimestamp = 0;
    this.title = "";
    this.isPush = false;
    this.timer = -1;
    // 設定データのインポート
    if (dataObj) {
      Object.assign(this, dataObj);
    }
  }

  //タイマーの設定
  @Catch()
  startTimer(timeup) {
      //残り時間を取得
      let rest = this.alarmTimestamp - Date.now();
      //タイマー起動
      this.timer = setTimeout(() => {
        timeup(this)
      }, rest);
  }

  //タイマーのキャンセル
  @Catch()
  cancelTimer() {
    clearTimeout(this.timer);
  }

  //待ち時間の設定(分)
  @Catch()
  setTimerValue(value: number) {
      this.timerValue = value;
      return this.update();
  }

  //アラーム設定時刻の更新
  @Catch()
  update(): Alarm {
    this.alarmTimestamp =
      Date.now() + this.timerValue * 60 * 1000;
    return this;
  }

  //アラーム設定時刻の文字表現取得
  @Catch()
  getTimeString(): string {
    let d = new Date(this.alarmTimestamp);
    let h = d.getHours();
    let m = ("0" + d.getMinutes()).slice(-2);
    let s = ("0" + d.getSeconds()).slice(-2);
    return h.toString() + ":" + m + ":" + s;
  }

  //デフォルトのアラーム名を設定
  @Catch()
  updateAlarmNameCounter(): string {
      let ret = localStorage.getItem("count");
      let counter = ret ? Number(ret) : 0;
      counter++;
      localStorage.setItem("count", counter.toString());
      this.title = "アラーム" + counter;
      return this.title;
  }

}
