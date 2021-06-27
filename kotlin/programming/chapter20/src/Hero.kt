// コンパイルされるクラスの名前を JvmName で指定する（リスト：20-20）
@file:JvmName("Hero")

import java.io.IOException

// main 関数と Jhava という相手を Kotlin で宣言する（リスト：20-2）
fun main(args: Array<String>) {
    val adversary = Jhava()
    // Kotlin で Java メソッドを呼び出す（リスト：20-3）
    println(adversary.utterGreeting())

    // 友情のレベルを表示する（リスト：20-5）
    val friendshipLevel = adversary.determineFriendshipLevel()
    // セーフコール演算子で null 許容処理（リスト：20-7）
    // エルヴィス演算子でデフォルト値を提供する（リスト：20-8）
    println(friendshipLevel?.toLowerCase() ?: "It's complicated.") 

    // Java フィールドへのリファレンスを取得する（リスト：20-11）
    val adversaryHitPoints: Int = adversary.hitPoints
    // java フィールドを kotlin から参照する（リスト：20-12）
    println(adversaryHitPoints.dec())
    // Java パッキングクラスの名前（リスト：20-13）
    println(adversaryHitPoints.javaClass)

    // Kotlin から Java フィールドをセットする（リスト：20-16）
    adversary.greeting = "Hello, Hero."
    println(adversary.utterGreeting())

    // offerFood をテストする（リスト：20-25）
    adversary.offerFood()

    // try/catch を使って例外を処理する（リスト：20-36）
    try {
        // 例外を送出するメソッドを呼び出す（リスト：20-35）
        adversary.extendHandInFriendship()
    } catch (e: Exception) {
        println("Begone, foul beast!")
    }
}

// Kotlin でトップレベルの関数を宣言する（リスト：20-17）
fun makeProclamation() = "Greetings, beast!"

// デフォルトパラメータを持つ関数を追加する（リスト：20-22）
// @JvmOverloads を追加する（リスト：20-24）
@JvmOverloads
fun handOverFood(leftHand: String = "berries", rightHand: String = "beef") {
    println("Mmmm... you hand over some delicious $leftHand and $rightHand.")
}

// チェックされない例外を送出する（リスト：20-37）
// @Throws アノテーションを使う（リスト：20-39）
@Throws(IOException::class)
fun acceptApology() {
    throw IOException()
}

// translator 関数型を定義する（リスト：20-40）
val translator = { utterance: String ->
    println(utterance.toLowerCase().capitalize())
}

// Spellbook クラスを追加する（リスト：20-26）
class Spellbook {
    // @JvmField アノテーションを適用する（リスト：20-27）
    @JvmField
    var spells = listOf("Magic Ms. L", "Lay on Hans")

    // コンパニオンオブジェクトを Spellbook に追加する（リスト：20-29）
    companion object {
        // @JvmField アノテーションをコンパニオンオブジェクトのメンバに追加する（リスト：20-31）
        @JvmField
        val MAX_SPELL_COUNT = 10

        // 関数に対して @JvmStatic を使う（リスト：20-32）
        @JvmStatic
        fun getSpellbookGreeting() = println("I am the Greet Grimoire!")
    }
}
