package com.programming.kotlin.chapter11

// ファイルからメニューデータを読み込む
import java.io.File

import kotlin.math.roundToInt
const val TAVERN_NAME = "Taerny1's Folly"

// プレイヤーの財布を設定する
//var playerGold = 10
//var playerSilver = 10

// 顧客リストをミュータブルにする
val patronList = mutableListOf("Eli", "Mordoc", "Sophie")

// 10人の客の名前をランダムに生成する
val lastName = listOf("Ironfoot", "Fernsworth", "Baggins")

// 集合を使って名前のユニークさを保証する
val uniquePatrons = mutableSetOf<String>()

// ファイルからメニューデータを読み込む
val menuList = File("data/tavern-menu-data.txt")
                .readText()
                .split("\n")

// メニュー１行の長さ
var menuLineLen = 0

// リードオンリーマップの作成（リスト：11-1）
//val patronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
// ミュータブルマップに記入する（リスト：11-5）
val patronGold = mutableMapOf<String, Double>()

fun main(args: Array<String>) {
    // 来客のチェック
    if (patronList.contains("Eli")) {
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }
    // 複数の来客をチェックする
    if (patronList.containsAll(listOf("Sophie", "Mordoc"))) {
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master saye: Nay, they departed hours ago.")
    }

    // 10人の客の名前をランダムに生成する
    (0..9).forEach {
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }
    //println(uniquePatrons)
    // ミュータブルマップに記入する（リスト：11-5）
    uniquePatrons.forEach {
        patronGold[it] = 6.0
    }

    // チャレンジ10.12
    showFormattedMenuList()

    // ユニークな顧客がランダムな注文を出す
    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }

    //println(patronGold)             // リスト：11-1
    //println(patronGold["Eli"])      // リスト：11-4
    //println(patronGold["Mordoc"])   // リスト：11-4
    //println(patronGold["Sophie"])   // リスト：11-4

    // 顧客たちの残金を表示する（リスト：11-7）
    displayPatronBalances()   // <Amendment03>mistype(patron -> pattern)
}

// patronGoldの値を更新する（リスト：11-6）
fun performPurchase(price: Double, patronName: String) {
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

// <Amendment03>mistype(patron -> pattern)
// 顧客たちの残金を表示する（リスト：11-7）
private fun displayPatronBalances() {
    patronGold.forEach { patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
} 

//fun performPurchase(price: Double) {
//    displayBalance()
//    val totalPurse = playerGold + (playerSilver / 100.0)
//    println("Total purse: $totalPurse")
//    println("Purchasing item for $price")

    // 財布から値段を引く
//    val remainingBalance = totalPurse - price
    // 残高のフォーマッティング
//    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    // 金と銀に変換する
//    val remainingGold = remainingBalance.toInt()
//    val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
//    playerGold = remainingGold
//    playerSilver = remainingSilver
//    displayBalance()
//}

//private fun displayBalance() {
//    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
//}

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
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

    // patronGoldの値を更新する（リスト：11-6）
    performPurchase(price.toDouble(), patronName)

    val phrase = if(name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

// 整形したメニューリストを出力する
private fun showFormattedMenuList() {
    //<Amendment01>
    //warning: variable 'numOfBlank' initializer is redundant
    //「冗長な初期化」という警告に対して、numOfBlankのスコープを狭めるよう、
    //宣言場所を必要なスコープの先頭に移動し、そこで設定する値を初期値とするよう変更
    //var numOfBlank = 0                        // 種類のヘッダにおける空白の数
    var maxNameLen = 0                          // 名前の最大長
    var maxPriceLen = 0                         // 価格の最大長
    var printed = Array(menuList.size, {0})     // 出力済フラグ
    var menuBuffer = StringBuilder()            // 出力用バッファ

    println("*** Welcome to $TAVERN_NAME ***")

    menuList.forEach { 
        // メニューリストの各行をカンマで分割
        val menusp = it.split(',')
 
        // 名前の最大長、価格の最大長を算出し、行の長さを決定する
        if (menusp[1].length > maxNameLen) {
            maxNameLen = menusp[1].length
        }

        if (menusp[2].length > maxPriceLen) {
            maxPriceLen = menusp[2].length
        }
    }

    // メニューリストの各項目最大長
    menuLineLen = maxNameLen + maxPriceLen + 5

    // メニューの個数分のループ
    for (i in 0..menuList.size - 1) {
        var (type, name, price) = menuList[i].split(',')

        // 出力済でなければ、出力
        if (printed[i] == 0) {
            //<Amendment01>
            // まず、種類を出力
            var numOfBlank = (menuLineLen - type.length) / 2 - 3
            (0..numOfBlank).forEach {
                menuBuffer.append(' ')
            }
            menuBuffer.append("- [" + type + "] -")
            println(menuBuffer)

            // 同じ種類があるか、カレント以降をさらにループ
            for (j in i + 1..menuList.size - 1) {
                var (_type, _name, _price) = menuList[j].split(',')

                // 同じ種類があれば、出力
                if (type == _type) {
                    //<Amendment02>
                    //showFormattedMenuLine(_type, _name, _price)
                    showFormattedMenuLine(_name, _price)
                    printed[j] = 1  // 出力したメニューは出力済にする
                }
            }
            //<Amendment02>
            //showFormattedMenuLine(type, name, price)
            showFormattedMenuLine(name, price)

            // 出力用バッファの初期化
            menuBuffer.delete(0, menuBuffer.length)
        }
    }
}

// メニュー１項目を整形表示
//<Amendment02>
//warning: parameter '_type' is never used
//「パラメータが未使用」という警告に対して、パラメータを減らす
private fun showFormattedMenuLine(_name: String, _price:String) {
    val menuBuffer = StringBuilder()

    // 構成する名前を空白で分割、単語の先頭を大文字化する
    var wordList = _name.split(' ')
    wordList.forEach {
        menuBuffer.append(it.capitalize() + ' ')
    }

    // 行の長さ、名前の長さ、価格の長さより名前と価格の間の点の数を決定する
    var periodNum = menuLineLen - menuBuffer.length - _price.length

    // 大文字化した後の名前、点、価格の形式で出力する
    (0..periodNum).forEach {
        menuBuffer.append('.')
    }
    menuBuffer.append(_price)
    println(menuBuffer)
}
