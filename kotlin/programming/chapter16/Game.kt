package com.programming.kotlin

import kotlin.system.exitProcess

fun main(args: Array<String>) {
    // オブジェクト宣言で定義した関数を呼び出す
    Game.play()
}

// Game オブジェクトの宣言
object Game {
    var loopFlag = true

    // プロパティと関数を、オブジェクト宣言に入れてカプセル化する
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    // NyetHack のワールドマップを定義する
    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room")))

    // init ブロックを Game に追加する
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }

    // オブジェクト宣言で定義した関数を呼び出す
    fun play() {
        while (loopFlag) {
            // ゲームループで状態を表示する
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            // ユーザーの入力を受け取る
            print("> Enter your command: ")
            GameInput(readLine()).processCommand()
        }
    }

    // プロパティと関数を、オブジェクト宣言に入れてカプセル化する
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    // ネストしたクラスを定義する
    private class GameInput(arg: String?) {
        // 入力された文字列を空白で分解する
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        // processCommand 関数を定義する
        fun processCommand() {
            when (command.toLowerCase()) {
                "move" -> move(argument)
                "exit" -> quit()            // quit コマンド
                "quit" -> quit()            // quit コマンド
                "map" -> showMap()
                "ring" -> ring()
                "fight" -> fight()          // fight コマンドを追加する（リスト：16-12）
                else -> commandNotFound()
            }
        }

        // 入力が無効な場合にメッセージを出力する
        private fun commandNotFound() {
            println("I'm not quite sure what you're trying to do!")
        }
    }

    // move 関数を定義する
    private fun move(directionInput: String) =
        try {
            val direction = Direction.valueOf(directionInput.toUpperCase())
            val newPosition = direction.updateCoordinate(player.currentPosition)
            if (!newPosition.isInBounds) {
                throw IllegalStateException("$direction is out of bounds.")
            }

            val newRoom = worldMap[newPosition.y][newPosition.x]
            player.currentPosition = newPosition
            currentRoom = newRoom
            println("OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}")
        } catch (e: Exception) {
            println("Invalid direction: $directionInput.")
        }
    
    // fight 関数を定義する（リスト：16-9）
    private fun fight() = currentRoom.monster?.let {
        while (player.healthPoints > 0 && it.healthPoints > 0) {
            // slay 関数を呼び出す（リスト：16-11）
            slay(it)

            Thread.sleep(1000)
        }

        "Combat complete."
    } ?: "There's nothing here to fight."

    // slay 関数を定義する（リスト：16-10）
    private fun slay(monster: Monster) {
        println("${monster.name} did ${monster.attack(player)} damage!")
        println("${player.name} did ${player.attack(monster)} damage!")

        if (player.healthPoints <= 0) {
            println(">>>> You have been defeated! Thanks for playing. <<<<")
            exitProcess(0)
        }

        if (monster.healthPoints <= 0) {
            println(">>>> ${monster.name} has been defeated! <<<<")
            currentRoom.monster = null
        }
    }

    // quitコマンド
    private fun quit() {
        println("Good bye! adventurer!")
        loopFlag = false
    }

    // マップを表示する
    private fun showMap() {
        var mapBuffer = ""
        for (i in 0..worldMap.size - 1) {
            for (j in 0..worldMap[i].size - 1) {
                if (player.currentPosition.y == i && player.currentPosition.x == j) {
                    mapBuffer = mapBuffer + "×"
                } else {
                    mapBuffer = mapBuffer + "○"
                }
            }
            mapBuffer = mapBuffer + "\n"
        }
        println(mapBuffer)
    }

    private fun ring() {
        if (currentRoom.name == "Town Square") {
            println(currentRoom.ringBell())
        }
    }
}
