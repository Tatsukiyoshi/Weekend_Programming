const fs = require("fs");
const PouchDB = require("pouchdb");
const PouchFind = require("pouchdb-find");
PouchDB.plugin(PouchFind);
const keycodes = require("./keycode.js");
let baseUrl = "https://localhost/db";
let infoDbUrl = baseUrl + "/kanko-info";
let favoriteDbUrl = baseUrl + "/kanko-favorite";

process.env["NODE_TLS_REJECT_UNAUTHORIZED"] = "0";
process.env["NPM_CONFIG_STRICT-SSL"] = false;

console.log("処理開始までしはらくお待ちください");
getInfoDB();

//観光情報DB生成
async function getInfoDB() {

  let infoDb;
  let favoriteDb;
  let newDoc;


    PouchDB.on('created', function (dbName) {
      console.log("succss db create: "+dbName);
    });

    PouchDB.on('destroyed', function (dbName) {
      console.log("db destroyed: "+dbName);
    });

  try {

    infoDb =new PouchDB(infoDbUrl);
    await infoDb.destroy().catch(e => {
      console.log("@@@" + e);
    });
    infoDb = new PouchDB(infoDbUrl);
    favoriteDb = new PouchDB(favoriteDbUrl);
    await favoriteDb.destroy().catch(e => {
      console.log("@@@" + e);
    });
    favoriteDb = new PouchDB(favoriteDbUrl);

    //インポートデータにid割り振り　prefCode_genreCode_serial
    docs = require("./importData");
    newDoc = docs.map((doc, index) => {

      if (doc.pref && doc.genre && doc.descript && doc.area && doc.photo.fileName) {
        doc._id = doc.area + doc.genre + "_" + (10000 + index);
        doc.keycode = doc.area + doc.genre;
      } else {
        throw new Error("データ項目欠落" + index);
      }
      return doc;
    });

    //写真データのとりこみ
    docs.forEach((doc, index) => {
      if (doc.photo) {
        //写真ファイル取得
        let filepath = __dirname + "/img_vga/" + doc.photo.fileName;
        let image = fs.readFileSync(filepath, {encoding: "base64"});
        // let image = fs.readFileSync(filepath, {encoding: "binary"});
        // let image = new Blob(filepath, {type: "image/jpg"});
        doc._attachments =
          {
            "photo": {
              data: image,
              content_type: "image/jpg"
            }
          };
        // console.log("@@@base64 size:" + image.length);
      }
    });


    // console.dir(newDoc);
  } catch (error) {
    throw new Error("データインポート失敗" + error.message);
  }

  console.log("@@@インポートデータ準備完了");

  //データインポート
  try {

    res = await infoDb.bulkDocs(docs).catch(e => {
      console.log("@@@Bulk Error" + e.toString());
      console.dir(e);
    })
    console.log("@@@DB生成");
    console.dir(res);

    res = await infoDb.createIndex({
      index: {
        fields: ["_id", "keycode"],
        ddoc: "infoDb-index"
      }
    }).catch(e=>console.log(e));
    console.log("@@@index生成");
    console.dir(res);

    res = await infoDb.createIndex({
      index: {
        fields: ["keycode"],
        ddoc: "infoDb-keycode"
      }
    }).catch(e=>console.log(e));;
    console.log("@@@index生成");
    console.dir(res);

    let ddoc = {
      _id: "_design/replicationDoc",
      filters: {
        mySearch: function (doc, req) {
          return (doc.keycode === req.query.key);
        }.toString()
      }
    };
    res = await infoDb.put(ddoc).catch(e=>console.log(e));;
    console.log("@@@ddoc生成");
    console.dir(res);

    ddoc = {
      _id: "_design/repFilter",
      filters: {
        ddocFilter: function (doc, req) {
          return (doc._id.substr(0, 7) !== "_design");
        }.toString()
      }
    };
    res = await infoDb.put(ddoc).catch(e=>console.log(e));
    console.log("@@@ddoc生成");
    console.dir(res);

    console.log("@@@" + "完了");
  } catch (err) {
    console.log("@@@Error" + err.message);
    console.dir(err);
  }

};

