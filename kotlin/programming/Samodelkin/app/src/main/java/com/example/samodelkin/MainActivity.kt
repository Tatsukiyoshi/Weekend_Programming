package com.example.samodelkin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Button
import android.widget.TextView

// displayCharacterData へのリファクタリング（リスト：21-5）
import kotlinx.android.synthetic.main.activity_main.*

// coroutines が 1.3から正式機能
//import kotlinx.coroutines.experimental.launch
//import kotlinx.coroutines.experimental.android.UI
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

// characterData をシリアライズする（リスト；21-7）
private const val CHARACTER_DATA_KEY = "CHARACTER_DATA_KEY"

// characterData の拡張プロパティを定義する（リスト：21-10）
private var Bundle.characterData
    get() = getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
    set(value) = putSerializable(CHARACTER_DATA_KEY, value)

class MainActivity : AppCompatActivity() {
    // characterData プロパティを定義する（リスト：21-3）
    private var characterData = CharacterGenerator.generate()

    // characterData をシリアライズする（リスト；21-7）
    override fun onSaveInstanceState(outState: Bundle, outPersistentState: PersistableBundle) {
        super.onSaveInstanceState(outState, outPersistentState)
        outState.putSerializable(CHARACTER_DATA_KEY, characterData)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // ビュー要素をルックアップする（リスト：21-2）
        //val nameTextView = findViewById<TextView>(R.id.nameTextView)
        //val raceTextView = findViewById<TextView>(R.id.raceTextView)
        //val dexterityView = findViewById<TextView>(R.id.dexterityTextView)
        //val wisdomTextView = findViewById<TextView>(R.id.wisdomTextView)
        //val strengthTextView = findViewById<TextView>(R.id.strengthTextView)
        //val generateButton = findViewById<Button>(R.id.generateButton)

        // キャラクタのデータを表示する（リスト：21-4）
        //characterData.run {
        //    nameTextView.text = name
        //    raceTextView.text = race
        //    dexterityTextView.text = dex
        //    wisdomTextView.text = wis
        //    strengthTextView.text = str
        //}

        // シリアライズしたキャラクターデータをフェッチする（リスト：21-9）
        //characterData = savedInstanceState?.let {
        //    it.getSerializable(CHARACTER_DATA_KEY) as CharacterGenerator.CharacterData
        //} ?: CharacterGenerator.generate()
        // 新しい拡張プロパティを使う（リスト：21-11）
        characterData = savedInstanceState?.characterData ?:
            CharacterGenerator.generate()

        // クイックリスナを設定する（リスト：21-6）
        //generateButton.setOnClickListener {
            // characterData = CharacterGenerator.generate()

            // fromApiData 関数をテストする（リスト：22-2）
            // characterData = CharacterGenerator.
            //    fromApiData("halfling,Lars Kizzy,14,13,8")

            // fetchCharacterData 関数を呼び出す（リスト：22-5）
            //characterData = fetchCharacterData()
            // API の結果を await で待つ（リスト：22-8）
            //launch(UI) {
            //    characterData = fetchCharacterData().await()
            //    displayCharacterData()
            //}
        //}
        // coroutines が 1.3から正式機能
        // https://discuss.kotlinlang.org/t/issue-with-coroutines/10461/5
        generateButton.setOnClickListener {
            GlobalScope.launch(Dispatchers.Main) {
                characterData = fetchCharacterData()
                displayCharacterData()
            }
        }
        displayCharacterData()
    }

    // displayCharacterData へのリファクタリング（リスト：21-5）
    private fun displayCharacterData() {
        characterData.run {
            nameTextView.text = name
            raceTextView.text = race
            dexterityTextView.text = dex
            wisdomTextView.text = wis
            strengthTextView.text = str
        }
    }
}
