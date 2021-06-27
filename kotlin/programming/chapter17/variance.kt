// Barrel を定義する（リスト：17-15）
// out を追加する（リスト：17-20）
//class Barrel<out T>(val item: T)
// Barrel に in でマークする（リスト：17-22）
class Barrel<in T>(item: T)

// main で２つの Barrel を定義する（リスト：17-16）
fun main(args: Array<String>) {
    var fedoraBarrel: Barrel<Fedora> =
            Barrel(Fedora("a generic-looking fedora", 15))
    var lootBarrel: Barrel<Loot> = Barrel(Coin(15))

    // lootBarrel への再代入を試みる（リスト：17-17）
    //lootBarrel = fedoraBarrel
    // 代入を逆転させる（リスト：17-23）
    fedoraBarrel = lootBarrel

    // コインを lootBarrel.item に代入する（リスト：17-18）
    // 代入を変更する（リスト：17-20）
    //lootBarrel.item = Coin(15)

    // fedoraBarrel.item をアクセスする（リスト：17-19）
    // 代入を変更する（リスト：17-20）
    //val myFedora: Fedora = fedoraBarrel.item
    val myFedora: Fedora = lootBarrel.item
}
