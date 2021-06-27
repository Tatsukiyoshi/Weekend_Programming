package com.programming.kotlin

// enum のコンストラクタを定義する
enum class Direction(private val coordinate: Coordinate) {
    NORTH(Coordinate(0, -1)),
    EAST(Coordinate(1, 0)),
    SOUTH(Coordinate(0, 1)),
    WEST(Coordinate(-1, 0));

    // enum のなかで関数を定義する
    fun updateCoordinate(playerCoordinate: Coordinate) =
        coordinate + playerCoordinate
}

// データクラスを定義する
data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0

    // plus 演算子を多重定義する
    operator fun plus(other: Coordinate) = Coordinate(x + other.x, y + other.y)
}
