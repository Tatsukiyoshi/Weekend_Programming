fun main(args: Array<String>) {
    // 動物のリストをシッポのある「赤ちゃん」に変換する（リスト：19-1）
    val animals = listOf("zebra", "giraffe", "elephant", "rat")
    val babies = animals
        .map { animal -> "A baby $animal"}
        .map { baby -> "$baby, with the cutest little tail ever!"}
    
    println(babies)

    // 元のコレクションは変更されてない（リスト：19-2）
    println(animals)

    // マッピングの前後で要素数は同じだが型は異なる（リスト：19-3）
    val tenDollarWords = listOf("auspicous", "avuncular", "obviate")
    val tenDollarWordLengths = tenDollarWords.map { it.length }
    println(tenDollarWordLengths)
    println(tenDollarWords.size)
    println(tenDollarWordLengths.size)

    // ２つのリストを平坦化する（リスト：19-4）
    var flatList = listOf(listOf(1, 2, 3), listOf(4, 5, 6)).flatMap { it }
    println(flatList)

    // フィルタリングと平坦化（リスト：19-5）
    val itemsOfManyColors = listOf(listOf("red apple", "green apple", "blue apple"),
        listOf("red fish", "blue fish"), listOf("yellow banana", "teal banana"))

    // "red"を含む項目に絞り、平坦化する
    val redItems = itemsOfManyColors.flatMap { it.filter { it.contains("red") } }
    println(redItems)

    // 素数以外をフィルタで除外する（リスト：19-6）
    val numbers = listOf(7, 4, 8, 4, 3, 22, 18, 11)
    val primes = numbers.filter { number ->
        (2 until number).map { number % it }
            .none { it == 0 }
        }
    println(primes)

    // ２つのコレクションを組み合わせる関数型の形式（リスト：19-7）
    val employees = listOf("Denny", "Claudette", "Peter")
    val shirtSize = listOf("large", "x-large", "medium")
    val employeeShirtSizes = employees.zip(shirtSize).toMap()
    println(employeeShirtSizes["Denny"])
    //println(employeeShirtSizes)

    // 値を組み合わせる
    val foldedValue = listOf(1, 2, 3, 4).fold(0) { accumulator, number ->
        println("Accumulated value: $accumulator")
        accumulator + (number * 3)
    }
    println("Final value: $foldedValue")
}
