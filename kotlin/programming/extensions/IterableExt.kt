// random エクステンションを IterableExt.kt に追加（リスト：18-14）
package com.programming.kotlin.extensions

fun <T> Iterable<T>.random(): T = this.shuffled().first()
