// チャレンジ：Mapのキーと値の関係を逆転させる
val gradesByStudent = mapOf("Josh" to 4.0, "Alex" to 2.0, "Jane" to 3.0)

private fun flipValues(maps: Map<String, Double>) =
    maps.map {
        it.value to it.key
    }

fun main(args: Array<String>) {
    println(gradesByStudent)

    val studentByGrades = flipValues(gradesByStudent)

    println(studentByGrades)
}
