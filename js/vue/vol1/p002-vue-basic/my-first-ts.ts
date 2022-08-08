class MyFirstTS {
    // プライベート変数 ...（1）
    // 型推論でstring型となる
    private name = ''
    // コンストラクター ...（2）
    public constructor(newName: string) {
        // this.nameはstring型なのでstring型のnewNameが代入できる ...（3）
        this.name = newName
    }
    // あいさつのメソッド ...（4）
    public getGreetText(): string {
        return `${this.name}さん、TypeScriptの世界にようこそ!`
    }
}
