fun main(args: Array<String>) {
    val player = Player("Madrigal")
    player.castFireball()

    // ルームの記述を表示する（リスト：14-2）
    //var currentRoom = Room("Foyer")
    // サブクラスによる関数の実装を呼び出す（リスト：14-10）
    var currentRoom: Room = TownSquare()
    println(currentRoom.description())
    println(currentRoom.load())

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
