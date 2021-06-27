package com.programming.kotlin

fun main(args: Array<String>) {
    // プロパティと関数を、オブジェクト宣言に入れてカプセル化する（リスト：15-4）
    //val player = Player("Madrigal")
    //player.castFireball()

    //var currentRoom: Room = TownSquare()

    // ゲームループで状態を表示する（リスト：15-5）
    //println(currentRoom.description())
    //println(currentRoom.load())

    //printPlayerStatus(player)

    // オブジェクト宣言で定義した関数を呼び出す（リスト：15-3）
    Game.play()
}

//private fun printPlayerStatus(player: Player) {
//    println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
//    println("${player.name} ${player.formatHealthStatus()}")
//}

// Game オブジェクトの宣言（リスト：15-1）
object Game {
    // プロパティと関数を、オブジェクト宣言に入れてカプセル化する（リスト：15-4）
    private val player = Player("Madrigal")
    private var currentRoom: Room = TownSquare()

    // NyetHack のワールドマップを定義する（リスト：15-18）
    private var worldMap = listOf(
        listOf(currentRoom, Room("Tavern"), Room("Back Room")),
        listOf(Room("Long Corridor"), Room("Generic Room")))

    // init ブロックを Game に追加する（リスト：15-2）
    init {
        println("Welcome, adventurer.")
        player.castFireball()
    }

    // オブジェクト宣言で定義した関数を呼び出す（リスト：15-3）
    fun play() {
        while (true) {
            // ゲームループで状態を表示する（リスト：15-5）
            println(currentRoom.description())
            println(currentRoom.load())

            printPlayerStatus(player)

            // ユーザーの入力を受け取る（リスト：15-6）
            print("> Enter your command: ")
            // GameInput を使う（リスト：15-10）
            //println("Last Command: ${readLine()}")
            println(GameInput(readLine()).processCommand())
        }
    }

    // プロパティと関数を、オブジェクト宣言に入れてカプセル化する（リスト：15-4）
    private fun printPlayerStatus(player: Player) {
        println("(Aura: ${player.auraColor()}) " + "(Blessed: ${if (player.isBlessed) "YES" else "NO"})")
        println("${player.name} ${player.formatHealthStatus()}")
    }

    // ネストしたクラスを定義する（リスト：15-7）
    private class GameInput(arg: String?) {
        // 入力された文字列を空白で分解する
        private val input = arg ?: ""
        val command = input.split(" ")[0]
        val argument = input.split(" ").getOrElse(1, { "" })

        // processCommand 関数を定義する（リスト：15-9）
        // processCommand 関数を定義する（リスト：15-20）
        fun processCommand() = when (command.toLowerCase()) {
            "move" -> move(argument)
            else -> commandNotFound()
        }

        // ネストしたクラスの中に関数を定義する（リスト：15-8）
        // 入力が無効な場合にメッセージを出力する
        private fun commandNotFound() = 
            "I'm not quite sure what you're trying to do!"
    }

    // move 関数を定義する（リスト：15-19）
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
            "OK, you move $direction to the ${newRoom.name}.\n${newRoom.load()}"
        } catch (e: Exception) {
            "Invalid direction: $directionInput."
        }
}
