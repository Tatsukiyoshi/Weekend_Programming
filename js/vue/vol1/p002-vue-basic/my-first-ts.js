"use strict";
class MyFirstTS {
    // コンストラクター ...（2）
    constructor(newName) {
        // プライベート変数 ...（1）
        // 型推論でstring型となる
        this.name = '';
        // this.nameはstring型なのでstring型のnewNameが代入できる ...（3）
        this.name = newName;
    }
    // あいさつのメソッド ...（4）
    getGreetText() {
        return `${this.name}さん、TypeScriptの世界にようこそ!`;
    }
}
