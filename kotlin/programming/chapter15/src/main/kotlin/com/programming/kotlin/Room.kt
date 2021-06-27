package com.programming.kotlin

// Room クラスを宣言する（リスト：14-1）
// Room クラスをサブクラスの作れる open クラスにする（リスト：14-3）
open class Room(val name: String) {
    // protected プロパティを宣言する（リスト：14-7）
    protected open val dangerLevel = 5

    fun description() = "Room: $name\n" + // Windows では\r\n
        "Danger level: $dangerLevel"

    // open 関数を宣言する（リスト：14-6）
    open fun load() = "Nothing much to see here..."
}

// TownSquare クラスを宣言する（リスト：14-4）
// 関数を final と宣言する（リスト：14-11）
open class TownSquare : Room("Town Square") {
    // dangerLevel をオーバーライドする（リスト：14-8）
    override val dangerLevel = super.dangerLevel - 3
    // 独自のプロパティと関数をサブクラスに追加する（リスト：14-9）
    private var bellSound = "GWONG"

    // TownSquare クラスを宣言する（リスト：14-5）
    final override fun load() = "The villegers rally and cheer as you enter!\n${ringBell()}"

    private fun ringBell() = "The bell tower announces your arrival. $bellSound"
}
