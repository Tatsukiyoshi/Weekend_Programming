// selectHometown 関数を定義する（リスト：13-10）
import java.io.File

// プライマリコンストラクタを定義する（リスト：13-1）
// プロパティをプライマリコンストラクタで定義する（リスト：13-3）
// コンストラクタでデフォルト引数を定義する（リスト：13-7）
// hometown プロパティ（リスト：13-11）
class Player (_name: String,
            var healthPoints: Int = 100,
            val isBlessed: Boolean,
            private val isImmortal: Boolean){
    var name = _name // "Madrigal"
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    
    // hometown プロパティを定義する（リスト：13-9）
    // selectHometown 関数を定義する（リスト：13-10）
    // hometown の遅延初期化（リスト：13-12）
    //val hometown = selectHometown()
    val hometown by lazy { selectHometown() }

    // 初期化ブロックを定義する（リスト：13-8）
    init {
        require(healthPoints > 0, { "healthPoints must be greater than zero." })
        require(name.isNotBlank(), { "Player must have a name." })
    }

    // セカンダリコンストラクタを定義する（リスト：13-4）
    // セカンダリコンストラクタにロジックを追加する（リスト：13-6）
    constructor(name: String) : this(name,
        //healthPoints = 100,
        isBlessed = true,
        isImmortal = false) {
            if (name.toLowerCase() == "kar") healthPoints = 40
        }
    //var healthPoints = _healthStatus     //89
    //val isBlessed = _isBlessed           //true
    //private val isImmortal = _isImmortal //false

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

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")    // Windows では、.split("\r\n")
        .shuffled()
        .first()
} 
