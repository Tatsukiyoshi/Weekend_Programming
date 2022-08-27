import {Injectable} from "@angular/core";
import {MyEvent, StateService} from "./state.service";
import {FAVORITE_URL, REMOTEDB_URL, RETRY_INTERVAL, USER_ID} from "../app.config";
import PouchDB from "pouchdb";
import HttpAdapter from "pouchdb-adapter-http";
PouchDB.plugin(HttpAdapter);
import PouchDbFind from "pouchdb-find";
PouchDB.plugin(PouchDbFind);
import {Router} from "@angular/router";
import {Catch, promiseError} from '../class/log.class';

@Injectable()
export class DbService {

  remoteDb;
  favoriteDb;
  remoteFavoriteDb;
  sync;
  rep;

  constructor(
    private stateService: StateService,
    private router: Router
  ) {
      PouchDB.on('created', function (dbName) {
          console.log("succss db create: "+dbName);
      });

      PouchDB.on('destroyed', function (dbName) {
          console.log("db destroyed: "+dbName);
      });
  }

    @Catch()
  async start(isReset?: boolean) {
    // PouchDB.debug.enable("pouchdb:find");
    // PouchDB.debug.disable("*");
    // PouchDB.debug.enable("*");


//    try {
      //remoteDBの初期化
      this.remoteDb = new PouchDB(REMOTEDB_URL);
      this.remoteFavoriteDb = new PouchDB(FAVORITE_URL);

      //favoriteDBの初期化
      this.favoriteDb = new PouchDB("favorite");
      let res = await this.favoriteDb.createIndex({
        index: {
          fields: ["timestamp"],
          sort: [{"timestamp": "desc"}],
          ddoc: "favoriteDb-timestamp"
        }
      }).catch(promiseError);

     await this.favoriteSync();

    // } catch (error) {
    //   throw new Error("データベース初期化失敗" + error.message);
    // }
  }

  //お気に入りデータの同期
    @Catch()
    async favoriteSync() {
    // try {
      this.sync = this.favoriteDb.sync(this.remoteFavoriteDb, {live: true, retry: true})
      .on("change",
        (info) => {
        let docs = info.change.docs;
        this.stateService.publish(MyEvent.DB_UPDATE);
        if(!docs)return;
            let msg=" 同期通知";
            msg+= (info.direction==="pull")?"[下り]":"[上り]";
            msg+=docs.length+"件\n";
            docs.forEach((doc,i )=>{
            msg +="#"+(i+1)+(doc._deleted)?"削除":"追加";
            msg +=" "+doc._id+(doc.name||"名前情報なし");
            console.log("@@@"+msg);
            });
          })
      .on("paused",
        () => {
          this.stateService.publish(MyEvent.DB_UPDATE);
        });
    // } catch (error) {
    //   throw new Error("" + error.message);
    // }
  }


  //お気に入りIDのハッシュ取得(id: true/false)
    @Catch()
  async getFavoriteId() {
    // try {
      let hash = {};
      let res = await this.favoriteDb.allDocs().catch(promiseError);
      console.dir(res);
      res.rows.map(row => hash[row.id] = true);
      console.dir(hash);
      return hash;
    // } catch (error) {
    //   throw new Error("お気に入りIdハッシュ取得失敗:" + error.message);
    // }
  }

  //お気に入りを登録
  //   @Catch()
  async saveFavorite(doc, blob?) {
    let latest;
    try {
      // サーバーDBへ状況確認
      latest = await this.remoteFavoriteDb.get(doc._id);
    } catch (error) {}
    try {
      let newDoc = await Object.assign({},doc);
      newDoc._rev =latest? latest._rev:doc._rev;
      let image = blob || await this.getPhoto(newDoc._id, true).catch(promiseError);
      newDoc.timestamp = Date.now();
      newDoc.timestr = (new Date()).toLocaleTimeString();
      newDoc.userId=USER_ID;
      newDoc._attachments = {
        "photo": {
          "content_type": "image/jpg",
          "data": image
        }
      };
      let res = await this.favoriteDb.put(newDoc, {force: true}).catch(promiseError);
      console.dir(res);
      return res;
    } catch (error) {
      throw new Error("お気に入り登録失敗" + error.message);
    }
  }

    // @Catch()
  async getFavorite() {
    try {
      let res = await this.favoriteDb.find({
        "selector": {
          "_id": {$gt: "0"},
          "timestamp": {$gt: 1}
        },
        "sort": [{"timestamp": "desc"}]
        ,
        "include_docs": true
        , use_index: "favoriteDb-timestamp"
      }).catch(promiseError);
      if(!res){
          console.log("res invarid"+res);
          return;
      }
        if(!res){
            console.log("res invarid"+res);
            return;
        }
      console.dir(res);
      this.stateService.docCount=res.docs.length;
      return await this.postProcess(res.docs,0,true).catch(promiseError);
    } catch (error) {
      throw new Error("お気に入り取得失敗" + error.message);
    }
  }

  //検索結果取得
    @Catch()
  async getDocs(query: any) {
    try {
      let res = await this.remoteDb.find({
        selector: {
          _id: {$gt: 0},
          keycode: {$in: this.stateService.state.selectedKeys}
        },
        use_index: "infoDb-index",
        limit: query.limit,
        skip: query.skip
      }).catch(promiseError);
        if(!res){
            console.log("res invarid"+res);
            return [];
        }
      console.dir(res);
      return await this.postProcess(res.docs,query.skip,false).catch(promiseError);
    } catch (error) {
      throw new Error("リモートDBからのgetDoc失敗" + error.message);
    }
  }

    @Catch()
async postProcess(docs, skip:number,isFavoriteDb:boolean){
  let ret: any;
  let favoriteHash;
  try {
    if(!isFavoriteDb){
     favoriteHash = await this.getFavoriteId().catch(promiseError);
    }
    if (docs && docs.length) {
      //通し番号付与
      let serial = skip + 1;
      docs.map((doc, i) => {
        doc.serial = serial++;
        doc.isFavorite =(isFavoriteDb)?true:(!!favoriteHash[doc._id]);
      });
      docs[0].isStart=true;
      docs[docs.length-1].isEnd=true;
    } else {
      throw new Error("docデータなし");
    }
    return docs;
  } catch (error) {
    console.log("postProcess失敗" + error.message);
  }
}


  //写真の取得
    @Catch()
  async getPhoto(id: string, isRemote: boolean) {
    let blob;
    let dataUrl;
    // try {
      if (isRemote) {
        blob = await this.remoteDb.getAttachment(id, "photo").catch(promiseError);
      } else {
        blob = await this.favoriteDb.getAttachment(id, "photo").catch(promiseError);
      }
      return blob;
    // } catch (error) {
    //   throw new Error("写真取得失敗:" + error.message);
    // }
  }

  @Catch()
  async deleteFavorite(doc) {
    let res;
    // try {
      res = await this.favoriteDb.get(doc._id).catch(promiseError);
    // } catch (error) {
    // }
    try {
      doc._rev = res ? res._rev : doc._rev;
      res = await this.favoriteDb.remove(doc._id, doc._rev).catch(promiseError);
    } catch (error) {
      if (error.status === 409) {
        console.log("@@@ Error409 削除自動リトライ");
        setTimeout(async () => {
          await this.deleteFavorite(doc).catch(promiseError);
        }, 1000);
        return;
      } else {
        throw new Error("お気に入り削除失敗" + error.message);
      }
    }

  }}
