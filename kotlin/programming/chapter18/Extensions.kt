package com.programming.kotlin.chapter18

// 拡張プロパティを追加する（リスト：18-8）
val String.numVowels
    get() = count { "aeiouy".contains(it)}

// String にエクステンションを追加する（リスト：18-1）
fun String.addEnthusiasm(amount: Int = 1) = this + "!".repeat(amount)

// null 許容型にエクステンションを追加する（リスト：18-10）
infix fun String?.printWithDefault(default: String) = print(this ?: default)

// Any を拡張する（リスト：18-3）
// easyPrint を連鎖可能にする（リスト：18-5）
// easyPrint をジェネリックにする（リスト：18-7）
//fun Any.easyPrint() = println(this)
//fun Any.easyPrint() : Any {
fun <T> T.easyPrint() : T {
    println(this)
    return this
}

// String 型のレシーバインスタンスで拡張関数を呼び出す（リスト：18-2）
fun main(args: Array<String>) {
    //println("Madrigal has left the building".addEnthusiasm())
    //"Madrigal has left the building".addEnthusiasm().easyPrint()
    // easyPrint を２回呼び出す（リスト：18-6）
    "Madrigal has left the building".easyPrint().addEnthusiasm().easyPrint()

    // easyPrint はすべてのサブタイプで利用できる（リスト：18-4）
    42.easyPrint()

    // 拡張プロパティを使う（リスト：18-9）
    "How many vowels?".numVowels.easyPrint()

    // null 許容型にエクステンションを追加する（リスト：18-10）
    val nullableString: String? = null
    nullableString printWithDefault "Default String"
}
