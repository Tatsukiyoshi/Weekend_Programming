package com.programming.kotlin.extensions

//fun frame(name: String, padding: Int, formatChar: String = "*"): String {
//    val greeting = "$name!"
//    val middle = formatChar.padEnd(padding)
//               .plus(greeting)
//               .plus(formatChar.padStart(padding))
//    val end = (0 until middle.length).joinToString("")
//
//    return "$end\n$middle\n$end\n"
//}

// チャレンジ12：額縁エクステンション
fun String.frame(padding: Int, formatChar: String = "*"): String {
    var end = ""
    val greeting = this
    val middle = formatChar.padEnd(padding + 1)
            .plus(greeting)
            .plus(formatChar.padStart(padding + 1))
    for (i in 1..middle.length) {
        end = end + formatChar
    }
    return "$end\n$middle\n$end\n"
}
