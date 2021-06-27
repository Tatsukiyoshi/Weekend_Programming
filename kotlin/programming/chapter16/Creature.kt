package com.programming.kotlin

import java.util.Random

// インターフェイスを定義する（リスト：16-1）
interface Fightable {
    var healthPoints: Int
    val diceCount: Int
    val diceSides: Int
    val damageRoll: Int
        // ゲッターのデフォルトの実装を定義する（リスト：16-4）
        get() = (0 until diceCount).map {
            Random().nextInt(diceSides + 1)
        }.sum()

    fun attack(opponent: Fightable): Int
}

// 抽象クラスを定義する（リスト：16-5）
abstract class Monster(val name: String,
                       val description: String,
                       override var healthPoints: Int) : Fightable {

    override fun attack(opponent: Fightable): Int {
        val damageDealt = damageRoll
        opponent.healthPoints -= damageDealt
        return damageDealt
    }  
}

// 抽象クラスのサブクラスを作る（リスト：16-6）
class Goblin(name: String = "Goblin",
             description: String = "A nasty-looking goblin",
             healthPoints: Int = 30) : Monster(name, description, healthPoints) {
    // 抽象クラスのサブクラスでプロパティを実装する（リスト：16-7）
    override val diceCount = 2
    override val diceSides = 8
}
