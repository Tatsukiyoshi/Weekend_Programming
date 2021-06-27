// ジェネリック型を作成する（リスト：17-1）
// ジェネリック型パラメータを Loot のみに制約する（リスト：17-9）
// vararg を追加する（リスト：17-10）
class LootBox<T : Loot>(vararg item: T) {
    // fetch 関数を追加する（リスト：17-3）
    var open = false

    // loot 配列をインデックス参照する（リスト：17-11）
    private var loot: Array<out T> = item

    // get 演算子を LootBox に追加する（リスト：17-13）
    operator fun get(index: Int): T? = loot[index].takeIf { open }

    // fetch 関数を追加する（リスト：17-3）
    // loot 配列をインデックス参照する（リスト：17-11）
    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }

    // 複数のジェネリック型パラメータを使う（リスト：17-6）
    // loot 配列をインデックス参照する（リスト：17-11）
    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }
}

// スーパークラスを追加する（リスト：17-8）
open class Loot(val value: Int)

// 宝箱を定義する（リスト：17-2）
// スーパークラスを追加する（リスト：17-8）
//class Fedora(val name: String, val value: Int)
class Fedora(val name: String, value: Int) : Loot(value)

//class Coin(val value: Int)
class Coin(value: Int) : Loot(value)

fun main(args: Array<String>) {
    // 新しい LootBox をテストする（リスト：17-12）
    val LootBoxOne: LootBox<Fedora> = 
            LootBox(Fedora("a generic-looking fedora", 15),
            Fedora("a dazzling magenta fedora", 25))
    val LootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    // 宝箱を開く（リスト：17-5）
    LootBoxOne.open = true

    // ジェネリックな fetch 関数をテストする（リスト：17-4）
    //LootBoxOne.fetch()?.run { 
    // 新しい LootBox をテストする（リスト：17-12）
    LootBoxOne.fetch(1)?.run {
        println("You retrieve $name from the box!")
    }

    // 変換関数を引数として渡す（リスト：17-7）
    //val coin = LootBoxOne.fetch() {
    // 新しい LootBox をテストする（リスト：17-12）
    val coin = LootBoxOne.fetch(0) {
        Coin(it.value * 3)
    }
    coin?.let { println(it.value) }

    // get を使う（リスト：17-14）
    val fedora = LootBoxOne[1]
    fedora?.let { println(it.name) }
}
