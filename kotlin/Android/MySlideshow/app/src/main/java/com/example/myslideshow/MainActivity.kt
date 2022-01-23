package com.example.myslideshow

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.myslideshow.databinding.ActivityMainBinding
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var player: MediaPlayer

    class MyAdapter(fa: FragmentActivity) : FragmentStateAdapter(fa) {
        private val resources = listOf(
            R.drawable.slide00, R.drawable.slide01,
            R.drawable.slide02, R.drawable.slide03,
            R.drawable.slide04, R.drawable.slide05,
            R.drawable.slide06, R.drawable.slide07,
            R.drawable.slide08, R.drawable.slide09
        )

        override fun getItemCount(): Int {
            return resources.size
        }

        override fun createFragment(position: Int): Fragment {
            TODO("Not yet implemented")
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.pager.adapter = MyAdapter(this)

        val handler = Handler(Looper.getMainLooper())
        timer(period = 5000) {
            handler.post {
                binding.pager.currentItem = (binding.pager.currentItem + 1) % 10
            }
        }
        player = MediaPlayer.create(this, R.raw.getdown)
        player.isLooping = true
    }

    override fun onResume() {
        super.onResume()
        player.start()
    }

    override fun onPause() {
        super.onPause()
        player.pause()
    }
}
