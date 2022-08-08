// クラスの実装（exportキーワードでモジュールにする） ...（1）
export class MyFirstTS {
    // プライベート変数
    private name = ''; // 型推論でstring型となる ...（2）

    // コンストラクター ...（3）
    public constructor(newName: string) {
        // this.nameはstring型なのでstring型のnewNameが代入できる
        this.name = newName
    }

    // あいさつのメソッド ...（4）
    public getGreetText(): string {
        return `${this.name}さん、Vue.js + TypeScriptの世界にようこそ!`
    }
}
