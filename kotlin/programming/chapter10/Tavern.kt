// ファイルからメニューデータを読み込む（リスト10-17）
import java.io.File

import kotlin.math.roundToInt
const val TAVERN_NAME = "Taerny1's Folly"

// プレイヤーの財布を設定する（リスト：８－１）
var playerGold = 10
var playerSilver = 10
// 顧客リストを作る（リスト10-1）
// 第一の顧客をアクセスする（リスト10-4）
// 顧客リストをミュータブルにする（リスト10-10）
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

// 10人の客の名前をランダムに生成する（リスト10-24）
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")

// 集合を使って名前のユニークさを保証する（リスト10-25）
val uniquePatrons = mutableSetOf<String>()

// ファイルからメニューデータを読み込む（リスト10-17）
val menuList = File("data/tavern-menu-data.txt")
                .readText()
                .split("\n")

fun main(args: Array<String>) {
    // 来客のチェック（リスト10-8）
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }
    // 複数の来客をチェックする（リスト10-9）
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master saye: Nay, they departed hours ago.")
    }

    //PlaceOrder("shandy,Dragon's Breath,5.91")
    //PlaceOrder("elixir,Shirley's Temple,4.12")

    // 第一の顧客をアクセスする（リスト10-4）
    //println(patronList[0])

    // 顧客リストをミュータブルにする（リスト10-10）
    //println(patronList)
    //patronList.remove("Eli")
    //patronList.add("Alex")
    
    // もう一人のAlexを追加する（リスト10-11）
    //patronList.add(0, "Alex")
    
    // セット演算子を使って、ミュータブルリストを変更する（リスト10-12）
    //patronList[0] = "Alexis"
    
    //println(patronList)

    // patronListを forで反復処理する（リスト10-13）
    //for (patron in patronList) {
    //    println("Good evening, $patron")
    //}

    // patronListをforEachで反復処理する（リスト10-14）
    //patronList.forEach { patron ->    
    //    println("Good evening, $patron")
    //}

    // forEachIndexedで順位を表示する（リスト10-15）
    // 複数の注文をシミュレートする（リスト10-16）
    //patronList.forEachIndexed { index, patron ->    
    //    println("Good evening, $patron - you're #${index + 1} in line.")
    //    PlaceOrder(patron, "shandy,Dragon's Breath,5.91")
    // ランダムな注文を出す（リスト：10-19）
    //    PlaceOrder(patron, menuList.shuffled().first())
    //}

    // 多彩になったメニューを出力する（リスト10-18）
    //menuList.forEachIndexed { index, data ->
    //    println("$index : $data")
    //}

    // 10人の客の名前をランダムに生成する（リスト10-24）
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        // 集合を使って名前のユニークさを保証する（リスト10-25）
        // println(name)
        uniquePatrons += name
    }
    println(uniquePatrons)

    // ユニークな顧客がランダムな注文を出す（リスト10-26）
    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(),
            menuList.shuffled().first())
        orderCount++
    }
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    // 財布から値段を引く（リスト：８－４）
    val remainingBalance = totalPurse - price
    // 残高のフォーマッティング（リスト：８－５）
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    // 金と銀に変換する（リスト：８－６）
    val remainingGold = remainingBalance.toInt()
    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
    playerGold = remainingGold
    playerSilver = remainingSilver
    displayBalance()
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aAeEiIoOuU]")) {
        when(it.value) {
            "a" -> "4"
            "e" -> "3"
            "i" -> "1"
            "o" -> "0"
            "u" -> "|_|"
            "A" -> "4"
            "E" -> "3"
            "I" -> "1"
            "O" -> "0"
            "U" -> "|_|"
            else -> it.value
        }
    }

private fun placeOrder(patronName: String, menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    //println("Madrigal speaks with $tavernMaster about their order.")
    println("$patronName speaks with $tavernMaster about their order.")

    //val data = menuData.split(',')
    //val type = data[0]
    //val name = data[1]
    //val price = data[2]
    val (type, name, price) = menuData.split(',')
    //val message = "Madrigal buys a $name ($type) for $price."
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

    // 価格の情報を渡す（リスト：８－２）
    // performPurchase(price)
    // Doubleに変換する（リスト：８－３）
    //performPurchase(price.toDouble())

    //val phrase = "Ah, delicious $name!"
    //println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
    val phrase = if(name == "Dragon's Breath") {
        //"Madrial exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        //"Madrial says: Thanks for the $name."
        "$patronName says: Thanks for the $name."
    }
    println(phrase)

    println("Madrial exclaims: ${toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURES CRAVE!")}")
}
