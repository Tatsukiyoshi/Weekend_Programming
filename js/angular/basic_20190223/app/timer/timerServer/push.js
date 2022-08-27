const webpush = require("web-push");
const keyPair = {
  "publicKey": "BHPaVzKDMAS_X3llcGHAKSckiFEJjLlAA0C6pGCbl2D80GuOZCGrVQPl5ITKJ3A3h2RraeWr_Uclup58bt7F2_A",
  "privateKey": "fWLsE2JdrBb2PkCsnS6x4zW4PF2eSjHr4CUX2DPxT7U"
};

// Pushクラスの宣言
module.exports = class Push {

  constructor() {
    this.alarm = [];
  }

  //アラーム登録
  addAlarm(alarm) {
    try {
      //設定時刻までの残り時間
      let rest = alarm.alarmTimestamp - Date.now();
      if(rest<30){
        return{success:false,
          data:"通知時刻まで30秒以下ですので登録できません"}
      }
      //残り時間をtimerにセット
      alarm.timer =
        setTimeout(() => {
          this.timeup(alarm);
        }, rest);
      //アラームをPushオブジェクトのプロパティに登録
      this.alarm.push(alarm);
      console.log("res: アラーム追加 ");
      //登録結果を返す
      return {success: true, data: alarm.title + "を追加しました  "
          + (new Date()).toLocaleTimeString()};
    }catch(error){
      return {success: false,data:"アラーム登録に失敗しました"};
    }
  }

  //アラーム設定時刻の処理(Pushサービスへ通知リクエスト)
  timeup(alarm) {
    try {
      let now = Date.now();
      this.sendNotification(alarm);
      let msg = alarm.title + "を通知しました";
      console.log(
        "タイマー通知:" + (new Date()).toLocaleTimeString()
      );
      return this.removeAlarm(alarm.id);
    } catch (error) {
      return {success: false,
        data:error.toString() + "通知リクエストに失敗しました"}
    }
  }

  //登録タイマーの削除
  removeAlarm(id) {
    let msg;
    try {
      for (let i = 0; i < this.alarm.length; i++) {
        if (this.alarm[i].id === id) {
          clearTimeout(this.alarm[i].timer);
          msg = this.alarm[i].title + "を削除しました";
          console.log("res: " + msg);
          this.alarm.splice(i, 1);
          return {success: true, data:msg};
        }
      }
      throw new Error("該当するアラームの登録なし")
    } catch (error) {
      return {success: false,
        data:error.toString() + "タイマー削除に失敗しました"};
    }
  }


    //公開鍵を返す
    getPublicKey(){
      return {success: true, data: keyPair.publicKey};
    }

    //タイムスタンプを時刻文字列に変換
    timeStampToString(timeStamp){
      let str = (new Date(timeStamp)).toLocaleTimeString();
      return str;
    }

    //Pushサービスへ通知のリクエスト
    async sendNotification(alarm){

      //Push通知データ
      let payload = {
        "notification": {
          "title": "時間になりました",
          "body": alarm.title
            + " 設定時刻=" + this.timeStampToString(alarm.alarmTimestamp)
            + " 通知時刻=" + (new Date()).toLocaleTimeString(),
          "icon": "assets/icons/info_icon_96.png",
          "vibrate": [100, 50, 100],
          "requireInteraction": true,
          "data": {
            "id": alarm.id,
            "url": alarm.baseUrl
          },
          "actions": [{
            "action": "open",
            "title": "マルチタイマー起動"
          }]
        }
      };

      //Web Pushライブラリに値を設定
      webpush.setVapidDetails(
        "https://localhost",
        keyPair.publicKey,
        keyPair.privateKey
      );

      //Push通知依頼
      try {
        console.log("@@@Push通知依頼 payload");
        console.dir(payload);
        //webpushライブラリで依頼送信
        let res = await webpush.sendNotification(
          alarm.pushSubscription, JSON.stringify(payload));
        console.dir(res);
        return res;
      } catch (e) {
        console.dir(e);
        throw new Error(e.message);
      }
    }
  };
