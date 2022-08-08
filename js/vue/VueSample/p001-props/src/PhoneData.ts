// スマートフォンのデータを表すクラス
export default class PhoneData {
    name: string = ''
    vendor: string = ''
    price: number = 0
    // コンストラクター
    constructor(paramName: string, paramVendor: string, paramPrice: number) {
        this.name = paramName
        this.vendor = paramVendor
        this.price = paramPrice
    }
    // 表示用の価格を取得するGetter
    get dispPrice(): string {
        return new Intl.NumberFormat('ja-JP').format(this.price)
    }
}
