fun main(args: Array<String>) {
    val name = "Madrigal"
    var healthPoints = 89
    var isBlessed = true
    var isImmortal = false

    // Aura
    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    // Player status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    var inebriation = castFireball((Math.random() * 5 + 1).toInt())
    printInebriationStatus(inebriation)
}

// formatting the HealthStatus 
private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

// print the status of player
private fun printPlayerStatus(auraColor: String,
                              isBlessed: Boolean,
                              name: String,
                              healthStatus: String) {
    println("(Aura: $auraColor) " + "(Blessed: ${if (isBlessed) "YES" else "NO"})")
    println("$name $healthStatus")
}

// set the auraColor
// チャレンジ 4.14（単一式関数）
private fun auraColor(isBlessed: Boolean,
                      healthPoints: Int,
                      isImmortal: Boolean) = 
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

// 4.5 ファイヤーボールの呪文 
// 4.15 ファイヤーボールの酩酊レベル
private fun castFireball(numFireballs: Int = 2): Int { 
    println("A glass of Fireball springs into existence. (x$numFireballs)")

    // １杯ずつ酩酊状態につながるように、杯数により、酩酊レベルを算定
    return (numFireballs - 1) * 10 + ((Math.random() * 10).toInt() + 1)
}

// 4.16 チャレンジ酩酊状態
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
