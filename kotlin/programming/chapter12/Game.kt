fun main(args: Array<String>) {
    // name を main から削除する（リスト：12-6）
    //val name = "Madrigal"
    // main から変数を削除（リスト：12-15）
    //var healthPoints = 89
    //val isBlessed = true
    //val isImmortal = false

    // Player を実体化する（リスト：12-2）
    val player = Player()

    // クラス関数を呼び出す（リスト：12-4）
    player.castFireball()

    // Aura
    // クラス関数を呼び出す（リスト：12-22）
    //val auraColor = auraColor(isBlessed, healthPoints, isImmortal)
    //val healthStatus = formatHealthStatus(healthPoints, isBlessed)
    val auraColor = player.auraColor()

    // Player status
    // Player の name プロパティを参照して解決する（リスト：12-7）
    // クラス関数を呼び出す（リスト：12-22）
    //printPlayerStatus(auraColor, isBlessed, player.name, healthStatus)
    printPlayerStatus(player)

    //castFireball()
}

// main から関数を削除する（リスト：12-18）
// formatting the HealthStatus 
//private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
//    when (healthPoints) {
//        100 -> "is in excellent condition!"
//        in 90..99 -> "has a few scratches."
//        in 75..89 -> if (isBlessed) {
//            "has some minor wounds but is healing quite quickly!"
//        } else {
//            "has some minor wounds."
//        }
//        in 15..74 -> "looks pretty hurt."
//        else -> "is in awful condition!"
//    }

// print the status of player
// クラス関数を呼び出す（リスト：12-22）
//private fun printPlayerStatus(auraColor: String,
//                              isBlessed: Boolean,
//                              name: String,
//                              healthStatus: String) {
//    println("(Aura: ${player.auraColor()} " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
//    println("$name $healthStatus")
//}
private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()} " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

// main から関数を削除する（リスト：12-18）
// set the auraColor
//private fun auraColor(isBlessed: Boolean,
//                      healthPoints: Int,
//                      isImmortal: Boolean) = 
//    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

// ファイヤーボールの呪文 
// ファイヤーボールの酩酊レベル
//private fun castFireball(numFireballs: Int = 2): Int { 
//    println("A glass of Fireball springs into existence. (x$numFireballs)")

    // １杯ずつ酩酊状態につながるように、杯数により、酩酊レベルを算定
//    return (numFireballs - 1) * 10 + ((Math.random() * 10).toInt() + 1)
//}

// チャレンジ酩酊状態
private fun printInebriationStatus(inebriation: Int) {
    var inebriationStatus = ""

    when (inebriation) {
        in 1..10 -> inebriationStatus = "tipsy"
        in 11..20 -> inebriationStatus = "sloshed"
        in 21..30 -> inebriationStatus = "soused"
        in 31..40 -> inebriationStatus = "stewed"
        in 41..50 -> inebriationStatus = "..t0aSt3d"
    } 
    println("$inebriation, $inebriationStatus")
}
