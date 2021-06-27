package com.programming.kotlin

// enum を定義する（リスト：15-13）
// enum のコンストラクタを定義する（リスト：15-14）
enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    // enum のなかで関数を定義する（リスト：15-15）
    fun updateCoordinate(playerCoordinate: Coordinate) =
        // 多重定義した演算子を使う（リスト：15-17）
        //Coordinate(playerCoordinate.x + coordinate.x,
        //    playerCoordinate.y + coordinate.y)
        coordinate + playerCoordinate
}

// データクラスを定義する（リスト：15-11）
data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0

    // plus 演算子を多重定義する（リスト：15-16）
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}
