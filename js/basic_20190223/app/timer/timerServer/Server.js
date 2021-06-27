const spdy = require("spdy");
const tcpPortUsed = require("tcp-port-used");
const http = require("http");
const fs = require("fs");
const fkill = require("fkill");
const port = {
  https: 443,
  http: 80
};

// Serverクラスの宣言
module.exports = class Server {

  constructor(httpsApp, httpApp) {
    Server.httpsApp = httpsApp;
    Server.httpApp = httpApp;
  }

  // サーバー起動
  static async init() {
    //現在時刻
    console.log("%s", (new Date().toLocaleTimeString()));
    //HTTPSポートの空きをチェック
    await Server.checkReadyPort(port.https);
    //HTTPSサーバー起動
    Server.createHttpsServer(Server.httpsApp);
    //HTTPポートの空きをチェック
    await Server.checkReadyPort(port.http);
    //HTTPサーバー起動
    Server.createHttpServer(Server.httpApp);
  }

//ポートの空き状況確認関数
  static async checkReadyPort(portNumber) {
    try {
      //空きチェック
      let ret = !(await tcpPortUsed.check(portNumber));
      let msg = portNumber.toString() + "番ポートを" + (ret ? "利用可能" : "利用できません");
      console.log(msg);
      //ポートを使用していタスクを強制終了
      if (!ret) {
        console.log(portNumber+"番ポートを強制終了します");
        await fkill(":"+portNumber,{force:true})
          .catch(e=>console.log(e.toString()));
      }
    } catch (err) {
      console.dir(err);
      process.exit(1);
    }
  }

  //HTTPS用サーバー
  static createHttpsServer(app) {
    //SPDYの設定項目
    const options = {
      //SSL通信用の証明書と秘密鍵
      key: fs.readFileSync("./localhost/key.pem"),
      cert: fs.readFileSync("./localhost/cert.pem"),
      requestCert: false,
      rejectUnauthorized: false,
      spdy: {
        protocols: ["h2", "http/1.1"],
        plain: false,
        "x-forwarded-for": true,
        connection: {
          windowSize: 1024 * 1024,
          autoSpdy31: false
        }
      }
    };

    //Httpsサーバー生成
    spdy.createServer(options, app).listen(port.https, err => {
      if (err) {
        console.dir(err);
        exit(1);
      }
      console.log("%s番ポートで待ち受け中...", port.https);
    });
  }

  //HTTP用サーバー生成
  static createHttpServer(app) {
    http.createServer(app).listen(port.http, err => {
      if (err) {
        console.dir(err);
        process.exit(1);
      }
      console.log("%s番ポートで待ち受け中...", port.http);
    });
  }
};