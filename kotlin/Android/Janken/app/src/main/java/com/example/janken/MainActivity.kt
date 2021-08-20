package com.example.janken

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.View
import androidx.core.content.edit
import com.example.janken.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.gu.setOnClickListener { onJankenButtonTapped(it) }
        binding.choki.setOnClickListener { onJankenButtonTapped(it) }
        binding.pa.setOnClickListener { onJankenButtonTapped(it) }

        // 共有プリファレンスをクリアする
        val pref = PreferenceManager.getDefaultSharedPreferences(this)
        pref.edit {
            clear()
        }
    }

    private fun onJankenButtonTapped(view: View?) {
        val intent = Intent(this, ResultActivity::class.java)

        // インテントに追加情報を格納する
        intent.putExtra("MY_HAND", view?.id)

        startActivity(intent)
    }
}
