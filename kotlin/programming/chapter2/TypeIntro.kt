// https://re-engines.com/2017/06/26/kotlinをはじめよう〜コレクションなど〜/
// コンパイル時定数
const val MAX_EXPERIENCE: Int = 5000

fun main(args: Array<String>) {
    // 変数の宣言
    var playerName: String = "Estragon"
    var experiencePoints: Int = 5
    
    // チャレンジ 2.9
    var hasSteed: Boolean = false

    // チャレンジ 2.10(ユニコーンの角)
    var pubName: String = "Unicorn's Horn" 
    var gold: Int = 50
    var drinks: List<String> = listOf<String>("mead", "wine", "LaCroix")

    experiencePoints += 5

    // 変数の出力
    println(experiencePoints)
    println(playerName)
    println(hasSteed)   // チャレンジ 2.9
    println(pubName)    // チャレンジ 2.10
    println(gold)
    println(drinks)
    println(playerName.reversed())  // チャレンジ 2.11（魔法の鏡）
}
