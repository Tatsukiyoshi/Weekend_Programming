//Angularビルドの出力フォルダ
const angularDist="../timerClient/dist";
//const angularDist="../timerFront/dist";

//同時接続数エラー発生の防止
require("events").EventEmitter.defaultMaxListeners = 100;

//モジュールのインポート
const path = require("path");
const bodyParser = require("body-parser");
const compression = require("compression");
const express = require("express");

//expressのApplicationオブジェクト生成
const httpsApp = express(); //https用
const httpApp = express();//http用

//独自作成したPushクラス
const Push = require("./push");
const push = new Push();

//独自作成したServerクラス
const Server = require("./server");
const server = new Server(httpsApp,httpApp);


//HTTP通信はHTTPS通信へリダイレクト
httpApp.use((req, res) => {
  res.redirect(`https://${req.hostname}${req.url}`);
});

//通信データの圧縮のミドルウェア設定
httpsApp.use(compression());

//requestのbodyをオブジェクトへ変換
httpsApp.use(bodyParser.json());


//======CORS(クロスドメインのリクエスト受付）=====

//CORSの処理
httpsApp.use(function (req, res, next) {
  let origin = req.get("Origin");
  if (origin) {
    //リクエストのオリジンをそのまま許可して返す（全てのオリジンを許可）
    res.set("Access-Control-Allow-Origin", origin);
    //許可するヘッダ
    res.set("Access-Control-Allow-Headers", "X-Requested-With, X-HTTP-Method-Override, Content-Type, Accept");
    //許可するメソッド
    res.set("Access-Control-Allow-Methods", "POST, GET, PUT, DELETE, OPTIONS");
    //Cookieの使用を許可
    res.set("Access-Control-Allow-Credentials", true);
    //preflight結果のキャッシュ期間（24時間）
    res.set("Access-Control-Max-Age", "86400");
  }
  next();
});

//CORS　Pre-flight（通信前の許可確認）
httpsApp.options("*", function (req, res, next) {
  console.log("@@@pre-flight OK");
  res.sendStatus(200);
});


//======Push通知関連========

//ブラウザへアプリサーバーの公開鍵を返信
httpsApp.get("/api/pubKey", (req, res, next) => {
  let ret=push.getPublicKey();
  console.log("res: 公開キーをブラウザへ送信");
  console.dir(ret);
  res.json(ret);
});

//ブラウザから許可情報とタイマー情報取得
httpsApp.post("/api/addAlarm", (req, res, next) => {
  console.log("req: ブラウザから許可情報とタイマー情報取得");
  console.dir(req.body);
  let ret = push.addAlarm(req.body);
  console.log("res: アラームの登録");
  console.dir(ret);
  res.json(ret);
});

//サーバへ登録済の通知をキャンセル
httpsApp.post("/api/removeAlarm", (req, res, next) => {
  let ret = push.removeAlarm(req.body);
  console.log("res: 登録したアラームをキャンセルしました");
  console.dir(ret);
  res.json(ret);
});

//===ファイルの返信====

//サービスワーカを返信
httpsApp.get("/service-worker.js", (req, res) => {
  res.sendFile(path.join(distPath, "service-worker.js"));
});
//Angularビルド出力先を参照
const distPath = path.resolve(angularDist);
httpsApp.use("/", express.static(distPath));

//サーバー動作確認用のパス
const docRootPath = path.resolve("./public");
httpsApp.use("/public", express.static(docRootPath));

//リクエストされたパスにファイルが存在しない時は、index.htmlを返す
httpsApp.use((req, res, next) => {
  res.sendFile(path.join(distPath, "index.html"));
});


//====リクエストのログ出力(時刻,プロトコル,URL)====
httpsApp.use("/", function (req, res, next) {
  console.log((new Date()).toLocaleTimeString()
    + "  " + req.protocol + " " + req.url);
  next();
});


//===============エラー処理====================
httpsApp.use(function (err, req, res, next) {
  console.error(err.stack);
  res.status(500).send("Web Error");
});

//Webサーバー起動
Server.init();