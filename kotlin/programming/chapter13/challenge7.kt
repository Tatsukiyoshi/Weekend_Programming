//
// チャレンジ問題13.7：エクスカリバーの謎
//
// name を参照する（リスト：13-14）
fun main(args: Array<String>) {
    // もう一度、name を参照する（リスト：13-17）
    val sword = Sword("Excelibur")
    println(sword.name)

    // 再び name を参照する（リスト：13-15）
    sword.name = "Gleipnir"
    println(sword.name)
}
