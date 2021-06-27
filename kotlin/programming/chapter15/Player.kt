package com.programming.kotlin

import java.io.File

class Player (_name: String,
            var healthPoints: Int = 100,
            val isBlessed: Boolean,
            private val isImmortal: Boolean){
    var name = _name
        get() = "${field.capitalize()} of $hometown"
        private set(value) {
            field = value.trim()
        }
    
    val hometown by lazy { selectHometown() }

    // プレイヤーの位置を追跡管理する（リスト：15-12）
    var currentPosition = Coordinate(0, 0)

    init {
        require(healthPoints > 0, { "healthPoints must be greater than zero." })
        require(name.isNotBlank(), { "Player must have a name." })
    }

    constructor(name: String) : this(name,
        isBlessed = true,
        isImmortal = false) {
            if (name.toLowerCase() == "kar") healthPoints = 40
        }

    fun formatHealthStatus() =
        when (healthPoints) {
            100 -> "is in excellent condition!"
            in 90..99 -> "has a few scratches."
            in 75..89 -> if (isBlessed) {
                "has some minor wounds but is healing quite quickly!"
            } else {
                "has some minor wounds."
            }
            in 15..74 -> "looks pretty hurt."
            else -> "is in awful condition!"
        }

    fun auraColor(): String {
        val auraVisible = isBlessed && healthPoints > 50 || isImmortal
        val auraColor = if (auraVisible) "GREEN" else "NONE"
        return auraColor
    }

    fun castFireball(numFireballs: Int = 2) =
        println("A glass of Fireball springs into existence. (x$numFireballs)")

    private fun selectHometown() = File("data/towns.txt")
        .readText()
        .split("\n")    // Windows では、.split("\r\n")
        .shuffled()
        .first()
} 
