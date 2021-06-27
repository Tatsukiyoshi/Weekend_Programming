fun main(args: Array<String>) {
    // プライマリコンストラクタを呼び出す（リスト：13-2）
    // セカンダリコンストラクタを呼び出す（リスト：13-5）
    //val player = Player()
    //val player = Player("Madrigal", 89, true, false)
    val player = Player("Madrigal")

    player.castFireball()

    val auraColor = player.auraColor()

    printPlayerStatus(player)
}

private fun printPlayerStatus(player: Player) {
    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
    println("${player.name} ${player.formatHealthStatus()}")
}

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
