package com.example.mycountdowntimer

import android.media.AudioAttributes
import android.media.SoundPool
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.mycountdowntimer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private lateinit var soundPool: SoundPool
    private var soundResId = 0

    // CountDownTimerクラスの継承
    inner class MyCountDownTimer(millisInFuture: Long,
                                 countDownInterval: Long) :
        CountDownTimer(millisInFuture, countDownInterval) {

        var isRunning = false // カウントダウン中か停止中かを示すフラグ

        // ミリ秒単位のタイマーの残り時間から分と秒を取り出してテキストビューに表示する
        override fun onTick(millisUntilFinished: Long) {
            val minute = millisUntilFinished / 1000L / 60L
            val second = millisUntilFinished / 1000L % 60L
            // "%1d:%2$02d"で分と秒を整形する
            binding.timerText.text = getString(R.string.timerTextFormat).format(minute, second)
        }

        override fun onFinish() {
            // onFinishで"0:00"と表示する
            binding.timerText.text = getString(R.string.finishTimerText)

            // サウンドを再生する
            soundPool.play(soundResId, 1.0f, 100f, 0, 0, 1.0f)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // "3:00"と表示する
        binding.timerText.text = getString(R.string.initialTimerText)

        // CountDownTimerを継承したクラスのインスタンスを作成する
        val initialCounter: Long = 3 * 60 * 1000
        val timer = MyCountDownTimer(initialCounter, 100)

        // フローティングアクションボタンをクリックしたときのリスナーを設定する
        binding.playStop.setOnClickListener {
            timer.isRunning = when(timer.isRunning) {
                true -> { // カウントダウン中の場合
                    timer.cancel() // カウントダウン停止
                    // 画像をプレイマークに変更する
                    binding.playStop.setImageResource(
                        R.drawable.ic_play_arrow_black_24dp
                    )
                    false
                }
                false -> { // 停止中の場合
                    timer.start() // カウントダウン開始
                    // 画像をストップマークに変更する
                    binding.playStop.setImageResource(
                        R.drawable.ic_stop_black_24dp
                    )
                    true
                }
            }
        }
    }

    // アクティビティが表示されたとき
    override fun onResume() {
        super.onResume()
        val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
        soundPool = SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build()

        // サウンドリソースを読み込む
        soundResId = soundPool.load(this, R.raw.bellsound, 1)
    }

    // アクティビティが非表示になったとき
    override fun onPause() {
        super.onPause()

        // SoundPoolクラスのインスタンスを解放する
        soundPool.release()
    }
}
