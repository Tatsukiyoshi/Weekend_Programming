package com.example.animalbook

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.animalbook.databinding.ActivitySubBinding

class SubActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySubBinding
    private lateinit var title: TitleFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySubBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.lionButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, LionFragment())
                addToBackStack(null)
                commit()
            }
        }

        binding.hippoButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, HippoFragment())
                addToBackStack(null)
                commit()
            }
        }

        binding.giraffeButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.container, GiraffeFragment())
                addToBackStack(null)
                commit()
            }
        }

        title = TitleFragment()
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.titleFrame, title)
            commit()
        }
    }

    override fun onResume() {
        super.onResume()
        title.setTitle("サブ画面")
    }
}
