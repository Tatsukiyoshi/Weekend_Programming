// Sword を定義する（リスト：13-13）
class Sword(_name: String) {
    var name = _name
        get() = "The Legendary $field"
        set(value) {
            field = value.toLowerCase().reversed().capitalize()
        }
    
    // 初期化ブロックを追加する（リスト：13-16）
    init {
        name = _name
    }
}