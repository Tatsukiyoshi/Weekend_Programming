// リスト6-17
fun main(args: Array<String>) {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient) {
        swordsJuggling = 2
    }

    try {
        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
    }
    catch(e: Exception) {
        println(e)
    }

    println("You Juggle $swordsJuggling swords!")
}

fun proficiencyCheck(swordsJuggling: Int?) {
    checkNotNull(swordsJuggling, { "Player cannot Juggle swords" })
}

class UnskilledSwordJuggleException() :
    IllegalStateException("Player cannot Juggle swords")

