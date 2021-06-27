//(1)パッケージのインポート
import {Injectable} from "@angular/core";

//(2)DI可能なクラスとして宣言
@Injectable()
export class StoreService {

  //(3)入力金額を保持
  private _value = 0;

  //(4)閲覧回数を保持
  private _counter = 0;

  //(5)コンストラクタ
  constructor() {
    console.log("@@@constructor");
  }

  //(６)受け取った値を保存
  setStore(value: number) {
    console.log("●●●setStore");
    this._value = value;
  }

  //(7)保存した値を読み取り
  getStore(): number {
    console.log("●●●getStore");
    return this._value;
  }

  //(8)閲覧回数を加算する
  addcounter() {
    console.log("●●●addCounter");
    this._counter++;
  }

  //(9)閲覧回数を返す
  getCounter() {
    console.log("●●●getCounter");
    return this._counter;
  }

}

