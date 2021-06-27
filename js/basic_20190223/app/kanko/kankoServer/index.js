/**
 * クライアントビルド出力フォルダ
  * @type {string}
 *
 * サンプルアプリではアンギュラーのビルド結果をサーバーにファイル転送する代わりに
 * ビルド出力したフォルダをサーバー直接読み取ります
 * 接続するフロントエンドのアプリ合わせて設定を変更します
 */
const angularDist = "../kankoClient/dist";

//=======初期設定====================
//パッケージのインポート
const path = require("path");//相対パスと絶対パスの変換などのおユーティリティ
const fs = require("fs");//node.jsファイルシステムパッケージ
const express_proxy = require('express-http-proxy');//プロキシ機能
const bodyParser = require("body-parser");//受信した http リクエストのボディ部分の解析
const compression = require("compression");//Web サーバーとブラウザ間のデータ圧縮
const PouchDB = require("pouchdb");
const express = require("express");
// const pouchdbDebug = require("pouchdb-debug");
const express_pouchdb = require("express-pouchdb");
// PouchDB.plugin(pouchdbDebug);
const Server = require("./Server.js");
// PouchDB.debug.enable('*');

//静的ファイル保存先
const distPath = path.resolve(angularDist);

//PaouchDBサーバー接続先 URL
// const baseUrl = "https://localhost/db";
const REMOTEDB_URL = "https://localhost/db/kanko-info";
const FAVORITE_URL = "https://localhost/db/kanko-favorite";

//expressのApplicationオブジェクト生成
const httpsApp = express(); //https(アプリ用）
const httpApp = express();//http(リダイレクト用)
const httpsAdmin = express();//https(管理用)

//=======PouchDBとexpressの接続====================
//DB保存先
let TempPouchDB = PouchDB.defaults({prefix: "./db/"});
//PouchDBをexpressのミドルウェアとして登録
httpsApp.use("/db", express_pouchdb(TempPouchDB));
//観光情報データベースとexpressを接続
let remoteInfoDb = new TempPouchDB(REMOTEDB_URL);
//お気に入りデータベースとexpressを接続
let remoteFavoriteDb = new TempPouchDB(FAVORITE_URL);

//=======リクエスト先の変更====================
//HTTP通信はHTTPS通信へリダイレクト
httpApp.use((req, res) => {
  res.redirect(`https://${req.hostname}${req.url}`);
});

//Fauxtonからのリクエストはurlをproxyで/db/urlへ変換
httpsAdmin.use(express_proxy('https://localhost', {
  proxyReqPathResolver: function (req) {
    var parts = req.url.split('?');
    var queryString = parts[1];
    var updatedPath = "/db"+parts[0];
    console.log("@@@updatedPath"+updatedPath);
    return updatedPath + (queryString ? '?' + queryString : '');
  }
}));

//===============リクエストの受信処理====================
//通信データの圧縮
httpsApp.use(compression());

//requestのbodyをオブジェクトへ変換
httpsApp.use(bodyParser.json());

//CORSの処理（クロスドメインの許可）
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

//リクエストのログ出力(時刻,プロトコル,URL)
httpsApp.use(function (req, res, next) {
  console.log((new Date()).toLocaleTimeString()
    + "  " + req.protocol + " " + req.url);
  next();
});

//===============応答処理====================

//サービスワーカファィルを返信
httpsApp.use("/service-worker.js", (req, res) => {
  res.sendFile(path.join(distPath, "service-worker.js"));
});

//静的ファイルの返信
httpsApp.use("/", express.static(distPath));

//リクエストされたパスにファイルが存在しない時は、index.htmlを返す
httpsApp.use((req, res, next) => {
  res.sendFile(path.join(distPath, "index.html"));
});

//===============エラー処理====================
httpsApp.use(function (err, req, res, next) {
  console.error(err.stack);
  res.status(500).send("Web Error");
});

//===============終了処理====================
//node.jsのプロセス遮断イベント
process.on("SIGTERM", closeDb); // for kill
process.on("SIGINT", closeDb); // for Ctrl+C

//アプリ終了時のデータベースClose処理
async function closeDb() {
  await remoteFavoriteDb.close().catch(e=>console.log(e.toString()));
  await remoteInfoDb.close().catch(e=>console.log(e.toString()));
  console.log("データベース停止完了");
  process.exit();
};


//===============起動処理====================
//Serverクラスへexpress Applicationオブジェクトを渡しサーバー起動
const server = new Server(httpsApp, httpsAdmin, httpApp);
Server.init();
