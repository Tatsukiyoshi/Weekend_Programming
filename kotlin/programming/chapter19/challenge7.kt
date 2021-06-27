val valuesToAdd = listOf(1, 18, 73, 3, 44, 6, 1, 33, 2, 22, 5, 7)

fun main(args: Array<String>) {
    print("Step 1:")
    println(valuesToAdd)

    // 5に満たない数を除外する(https://code-examples.net/ja/q/2a0e495)
    val values2 = valuesToAdd.filter { it >= 5 }
    print("Step 2:")
    println(values2)

    // 2つずつ掛け合わせる組を作る
    val values3 = values2.windowed(2, 2)
    print("Step 3:")
    println(values3)

    // 2つずつの積の総和を求める
    var values4:Int = 0
    print("Step 4:")
    values3.forEach { values ->
        val value4 = values[0] * values[1]
        print(value4)
        values4 = values4 + value4
        print(" ")
    }
    println(values4)
}
