// チャレンジ８．１０：持ち金が足りなくなったら
import kotlin.math.roundToInt
const val TAVERN_NAME = "Taerny1's Folly"

// プレイヤーの財布を設定する（リスト：８－１）
var playerGold = 10
var playerSilver = 10

// Dragon's Breathの量を設定する
var breathMount: Double = 5.0

fun main(args: Array<String>) {
    PlaceOrder("shandy,Dragon's Breath,5.91")
    //PlaceOrder("elixir,Shirley's Temple,4.12")
}

fun performPurchase(type: String, name: String, price: Double) {
    var message: String

    displayBalance()
    val totalPurse = playerGold + (playerSilver / 100.0)
    println("Total purse: $totalPurse")
    println("Purchasing item for $price")

    // 財布から値段を引く（リスト：８－４）
    val remainingBalance = totalPurse - price

    if(remainingBalance > 0) {
        message = "Madrigal buys a $name ($type) for $price."
    } else {
        message = "the customer is short on gold."
    }
    println(message)

    if(remainingBalance > 0) {
        // 残高のフォーマッティング（リスト：８－５）
        println("Remaining balance: ${"%.2f".format(remainingBalance)}")

        // 樽から１パイント（０．１２５ガロン）注ぎ出す
        breathMount = breathMount - 0.125

        // 金と銀に変換する（リスト：８－６）
        val remainingGold = remainingBalance.toInt()
        val remainingSilver = (remainingBalance % 1 * 100).roundToInt()
        playerGold = remainingGold
        playerSilver = remainingSilver
        displayBalance()
    }
}

private fun displayBalance() {
    println("Player's purse balance: Gold: $playerGold , Silver: $playerSilver")
    displayMount()
}

private fun displayMount() {
    println("Dragon's Breath mount: $breathMount")
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

private fun PlaceOrder(menuData: String) {
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("Madrigal speaks with $tavernMaster about their order.")

    //val data = menuData.split(',')
    //val type = data[0]
    //val name = data[1]
    //val price = data[2]
    val (type, name, price) = menuData.split(',')
    //val message = "Madrigal buys a $name ($type) for $price."
    //println(message)

    // 価格の情報を渡す（リスト：８－２）
    // performPurchase(price)
    // Doubleに変換する（リスト：８－３）
    // performPurchase(price.toDouble())
    performPurchase(type, name, price.toDouble())
    performPurchase(type, name, price.toDouble())
    performPurchase(type, name, price.toDouble())

    //val phrase = "Ah, delicious $name!"
    //println("Madrigal exclaims: ${toDragonSpeak(phrase)}")
    val phrase = if(name == "Dragon's Breath") {
        "Madrial exclaims: ${toDragonSpeak("Ah, delicious $name!")}"
    } else {
        "Madrial says: Thanks for the $name."
    }
    println(phrase)

    println("Madrial exclaims: ${toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURES CRAVE!")}")
}
