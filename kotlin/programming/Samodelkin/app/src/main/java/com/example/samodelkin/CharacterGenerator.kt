package com.example.samodelkin

// coroutines が 1.3から正式機能
//import kotlinx.coroutines.experimental.async
//import kotlinx.coroutines.experimental.Deferred
import kotlinx.coroutines.*

// CharacterData クラスを Serializable にする（リスト：21-8）
import java.io.Serializable
// fetchCharacterData 関数を追加する（リスト：22-4）
import java.net.URL

private const val CHARACTER_DATA_API = "https://chargen-api.herokuapp.com/"

// CharacterGenerator オブジェクト（リスト：21-1）
private fun <T> List<T>.rand() = shuffled().first()

private fun Int.roll() = (0 until this)
    .map { (1..6).toList().rand() }
    .sum()
    .toString()

private val firstName = listOf("Eli", "Alex", "Sophie")
private val lastName = listOf("Lightweaver", "Greatfoot", "Oakenfeld")

object CharacterGenerator {
    data class CharacterData(val name: String,
                             val race: String,
                             val dex: String,
                             val wis: String,
                             val str: String) : Serializable
    private fun name() = "${firstName.rand()} ${lastName.rand()}"

    private fun race() = listOf("dwarf", "elf", "human", "halfling").rand()

    private fun dex() = 4.roll()

    private fun wis() = 3.roll()

    private fun str() = 5.roll()

    fun generate() = CharacterData(name = name(),
        race = race(),
        dex = dex(),
        wis = wis(),
        str = str())

    // fromApiData 関数を追加する（リスト：22-1）
    fun fromApiData(apiData: String): CharacterData {
        val (race, name, dex, wis, str) =
            apiData.split(",")
        return CharacterData(name, race, dex, wis, str)
    }
}

// fetchCharacterData 関数を追加する（リスト：22-4）
//fun fetchCharacterData(): CharacterGenerator.CharacterData {
// fetchCharacterData を非同期にする（リスト：22-7）
// coroutines が 1.3から正式機能
//fun fetchCharacterData(): Deferred<CharacterGenerator.CharacterData> {
//    return async {
//        val apiData = URL(CHARACTER_DATA_API).readText()
//        CharacterGenerator.fromApiData(apiData)
          //return CharacterGenerator.fromApiData(apiData)
//    }
//}
// https://discuss.kotlinlang.org/t/issue-with-coroutines/10461/5
suspend fun fetchCharacterData(): CharacterGenerator.CharacterData = withContext(Dispatchers.Default){
    val apiData = withContext(Dispatchers.IO) { URL(CHARACTER_DATA_API).readText() }
    CharacterGenerator.fromApiData(apiData)
}
