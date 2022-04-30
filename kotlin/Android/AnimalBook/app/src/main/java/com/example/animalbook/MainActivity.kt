package com.example.animalbook

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.commit
import com.example.animalbook.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // フラグメントの生成およびタイトル設定
        val fragment = TitleFragment()
        // fragment.setTitle("フラグメント動物図鑑")

        // フラグメントマネージャーの取得
        val fragmentManager: FragmentManager = this.supportFragmentManager

        // アクティビティにフラグメントを追加
        fragmentManager.commit {
//          replace(R.id.container, fragment)
            addToBackStack(null)
        }

        binding.nextButton.setOnClickListener {
            val intent = Intent(this, SubActivity::class.java)
            startActivity(intent)
        }
    }
}

