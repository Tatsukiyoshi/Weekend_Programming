//====================
// PermisionServiceクラス
//　・許可状況確認
//  ・通知ダイアログの表示許可
//====================

import {Injectable} from '@angular/core';
import {Catch} from "../class/log.class";

@Injectable()
export class PermissionService {

  //通知ダイアログ表示の許可状況取得
  @Catch()
  async isGranted(): Promise<string> {
    if (!("Notification" in window)) {
      throw new Error("通知APIを利用できません");
    }

    //通知許可の状況取得("default" | "denied" | "granted")
    let state = Notification["permission"];
    if (state == "granted" || state == "default") {
      console.log("state=" + state);
      return state;
    }
    throw new Error(state + "このサイトの通知はブロックされます");
  }


  //ユーザーから通知ダイアログ表示の許可を受ける
  @Catch()
  async confirm() {
    //許可依頼ダイアログの事前説明
    alert("次のダイアログで[許可]を選択すると\n" +
      "このサイトを閉じても、タイマーは確実にアラートを表示します");

    //許可依頼ダイアログの表示
    let res;
    res = await Notification.requestPermission();
    console.log("reqPermission =" + res);

    switch (res) {
      case "granted":
        alert("このサイトからの通知を許可します");
        return true;
      case "denied":
        alert("このサイトからの通知はブロックします");
        return false;
      default :
        alert("通知の許可は、保留されました");
        return false;
    }
  }
}

