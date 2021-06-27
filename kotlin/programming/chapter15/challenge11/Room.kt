package com.programming.kotlin

// Room クラスを宣言する
open class Room(val name: String) {
    // protected プロパティを宣言する
    protected open val dangerLevel = 5

    // チャレンジ問題11：鐘を鳴らす
    // 独自のプロパティと関数をサブクラスからスーパークラスに移動する
    private var bellSound = "GWONG"

    fun description() = "Room: $name\n" + // Windows では\r\n
        "Danger level: $dangerLevel"

    // open 関数を宣言する
    open fun load() = "Nothing much to see here..."

    // チャレンジ問題11：鐘を鳴らす
    // ring コマンド用に Public に変更する
    public fun ringBell() = "The bell tower announces your arrival. $bellSound"
}

// TownSquare クラスを宣言する
open class TownSquare : Room("Town Square") {
    // dangerLevel をオーバーライドする
    override val dangerLevel = super.dangerLevel - 3

    // TownSquare クラスを宣言する
    final override fun load() = "The villegers rally and cheer as you enter!\n${ringBell()}"
}
