//最大同時接続数の設定
require("events").EventEmitter.defaultMaxListeners = 100;

//パッケージのインポート
const spdy = require("spdy");
const tcpPortUsed = require("tcp-port-used");
const http = require("http");
const fs = require("fs");
const fkill = require("fkill");
const listenPort = {
  https: 443,
  http: 80,
  admin: 5100
};

// Serverクラスの宣言
module.exports = class Server {

  constructor(httpsApp, httpsAdmin, httpApp) {
    Server.httpsApp = httpsApp;
    Server.httpsAdmin = httpsAdmin;
    Server.httpApp = httpApp;
  }

  // サーバー起動
  static async init() {

    //証明書の厳密なチェック回避
    process.env["NODE_TLS_REJECT_UNAUTHORIZED"] = "0";
    process.env["NPM_CONFIG_STRICT-SSL"] = false;

    //現在時刻
    console.log("%s", (new Date().toLocaleTimeString()));
    //HTTPポートの空きをチェック
    await Server.checkReadyPort(listenPort.http);
    //HTTPサーバー起動
    Server.createHttpServer(Server.httpApp, listenPort.http);
    //HTTPSポートの空きをチェック
    await Server.checkReadyPort(listenPort.https);
    //HTTPSサーバー起動
    Server.createHttpsServer(Server.httpsApp, listenPort.https);
    //HTTPSポートの空きをチェック
    await Server.checkReadyPort(listenPort.admin);
    //HTTPSサーバー起動
    Server.createHttpsServer(Server.httpsAdmin, listenPort.admin);
  }

  //ポートの空き状況確認と使用中プロセスの強制終了
  static async checkReadyPort(portNumber) {
    try {
      //空きチェック
      let ret = !(await tcpPortUsed.check(portNumber));
      let msg = portNumber.toString() + "番ポートを"
        + (ret ? "利用可能" : "利用できません");
      console.log(msg);
      //ポートを使用していタスクを強制終了
      if (!ret) {
        console.log(portNumber + "番ポートを強制終了します");
        await fkill(":" + portNumber, {force: true})
          .catch(e => console.log(e.toString()));
      }
    } catch (err) {
      console.dir(err);
      process.exit(1);
    }
  }

  //HTTPS用サーバー
  static createHttpsServer(app, port) {
    //SPDYの設定項目
    const options = {
      //SSL通信用の証明書と秘密鍵
      key: fs.readFileSync("./localhost/key.pem"),
      cert: fs.readFileSync("./localhost/cert.pem"),
      requestCert: false,
      rejectUnauthorized: false,
      spdy: {
        protocols: ["h2", "spdy/3.1","http/1.1"],
        plain: false,
        "x-forwarded-for": true,
        connection: {
          windowSize: 1024 * 1024,
          autoSpdy31: false
        }
      }
    };

    //Httpsサーバー生成
    spdy.createServer(options, app).listen(port, err => {
      if (err) {
        console.dir(err);
        process.exit(1);
      }
      console.log("%s番ポートで待ち受け中...", port);
    });
  }

  //HTTP用サーバー生成
  static createHttpServer(app, port) {
    http.createServer(app).listen(port, err => {
      if (err) {
        console.dir(err);
        process.exit(1);
      }
      console.log("%s番ポートで待ち受け中...", port);
    });
  }

};

