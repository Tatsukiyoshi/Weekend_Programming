package com.programming.kotlin

// Room クラスを宣言する
open class Room(val name: String) {
    // protected プロパティを宣言する
    protected open val dangerLevel = 5

    fun description() = "Room: $name\n" + // Windows では\r\n
        "Danger level: $dangerLevel"

    // open 関数を宣言する
    open fun load() = "Nothing much to see here..."
}

// TownSquare クラスを宣言する
open class TownSquare : Room("Town Square") {
    // dangerLevel をオーバーライドする
    override val dangerLevel = super.dangerLevel - 3
    // 独自のプロパティと関数をサブクラスに追加する
    private var bellSound = "GWONG"

    // TownSquare クラスを宣言する
    final override fun load() = "The villegers rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}
