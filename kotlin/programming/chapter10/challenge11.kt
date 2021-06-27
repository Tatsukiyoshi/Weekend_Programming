//
// チャレンジ問題10.11：タバーンメニューのフォーマット
//

// ファイルからメニューデータを読み込む
import java.io.File

import kotlin.math.roundToInt
const val TAVERN_NAME = "Taerny1's Folly"

// プレイヤーの財布を設定する
var playerGold = 10
var playerSilver = 10

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
    println(uniquePatrons)

    // チャレンジ10.11
    println("*** Welcome to $TAVERN_NAME ***")
    showFormattedMenuList()

    // ユニークな顧客がランダムな注文を出す
    var orderCount = 0
    while (orderCount <= 9) {
        placeOrder(uniquePatrons.shuffled().first(), menuList.shuffled().first())
        orderCount++
    }
}

fun performPurchase(price: Double) {
    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    // 財布から値段を引く
    val remainingBalance = totalPurse - price
    // 残高のフォーマッティング
    println("Remaining balance: ${"%.2f".format(remainingBalance)}")

    // 金と銀に変換する
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
    println("$patronName speaks with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name ($type) for $price."
    println(message)

    val phrase = if(name == "Dragon's Breath") {
        "$patronName exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

// 整形したメニューリストを出力する
private fun showFormattedMenuList() {
    var maxNameLen = 0
    var maxPriceLen = 0

    // メニューリストの各行をカンマで分割し、
    // 名前の最大長、価格の最大長を算出し、行の長さを決定する
    menuList.forEach { menu ->
        val menusp = menu.split(',')
 
        if (menusp[1].length > maxNameLen) {
            maxNameLen = menusp[1].length
        }

        if (menusp[2].length > maxPriceLen) {
            maxPriceLen = menusp[2].length
        }
    }

    // メニューリストの各項目最大長
    menuLineLen = maxNameLen + maxPriceLen + 5

    menuList.forEach {
        val menuBuffer = StringBuilder()
        var menusp = it.split(',')

        // 構成する名前を空白で分割、単語の先頭を大文字化する
        var wordList = menusp[1].split(' ')
        wordList.forEach {
            menuBuffer.append(it.capitalize() + ' ')
        }
        // 行の長さ、名前の長さ、価格の長さより名前と価格の間の点の数を決定する
        var periodNum = menuLineLen - menuBuffer.length - menusp[2].length

        // 大文字化した後の名前、点、価格の形式で出力する
        (0..periodNum).forEach {
            menuBuffer.append('.')
        }
        menuBuffer.append(menusp[2])
        println(menuBuffer)
    }
}
