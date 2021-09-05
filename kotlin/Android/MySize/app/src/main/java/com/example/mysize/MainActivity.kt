package com.example.mysize

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import androidx.core.content.edit
import com.example.mysize.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 共有プリファレンスから取得
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        val editNeck = pref.getString("NECK", "")
        val editSleeve = pref.getString("SLEEVE", "")
        val editWaist = pref.getString("WAIST", "")
        val editInseam = pref.getString("INSEAM", "")

        // 取得した値をEditTextビューに表示
        binding.neck.setText(editNeck)
        binding.sleeve.setText(editSleeve)
        binding.waist.setText(editWaist)
        binding.inseam.setText(editInseam)

        // 保存ボタンがタップされたときのリスナーセット
        binding.save.setOnClickListener { onSaveTapped() }

        binding.heightButton.setOnClickListener {
            val intent = Intent(this, HeightActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onSaveTapped() {
        val pref = PreferenceManager.getDefaultSharedPreferences(this)

        pref.edit {
            putString("NECK", binding.neck.text.toString())
            putString("SLEEVE", binding.sleeve.text.toString())
            putString("WAIST", binding.waist.text.toString())
            putString("INSEAM", binding.inseam.text.toString())
        }
    }
}
