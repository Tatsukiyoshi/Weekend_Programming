package com.programming.kotlin

// データクラスを定義する（リスト：15-11）
data class Coordinate(val x: Int, val y: Int) {
    val isInBounds = x >= 0 && y >= 0
}
