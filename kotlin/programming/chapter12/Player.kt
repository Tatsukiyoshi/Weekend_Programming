// Player クラスを定義する（リスト：12-1）
class Player {
    // name プロパティを定義する（リスト：12-5）
    // name をミュータブルにする（リスト：12-10）
    //val name = "Madrigal"
    var name = "Madrigal"
        // カスタムゲッターを定義する（リスト：12-8）
        get() = field.capitalize()
        // カスタムセッターを定義する（リスト：12-9）
        // name の」セッターを隠す（リスト：12-12）
        private set(value) {
            field = value.trim()
        }

    // プロパティを Player に追加（リスト：12-16）
    var healthPoints = 89
    val isBlessed = true
    // isImmortal を Playerに入れてカプセル化する（リスト：12-17）
    private val isImmortal = false

    // クラス関数を Player に追加する（リスト：12-19）
    // クラス関数から不要になったパラメータを削除する（リスト：12-20）
    // クラス関数をパブリックにする（リスト：12-21）
    //private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    fun formatHealthStatus() =
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

    //private fun auraColor(isBlessed: Boolean,
    //                      healthPoints: Int,
    //                      isImmortal: Boolean): String {
    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    // クラス関数を定義する（リスト：12-3）
    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")
} 
