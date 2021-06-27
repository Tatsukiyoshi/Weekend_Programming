package com.example.mycountdowntimer

import android.content.IntentSender
import android.media.AudioAttributes
import android.media.AudioManager
import android.media.SoundPool
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.concurrent.timer

class MainActivity : AppCompatActivity() {

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
            timerText.text = "%1d:%2$02d".format(minute, second)
        }

        override fun onFinish() {
            timerText.text = "0:00" // onFinishで"0:00"と表示する

            // サウンドを再生する
            soundPool.play(soundResId, 1.0f, 100f, 0, 0, 1.0f)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        timerText.text = "3:00" // "3:00"と表示する

        // CountDownTimerを継承したクラスのインスタンスを作成する
        val timer = MyCountDownTimer(3 * 60 * 1000, 100)

        // フローティングアクションボタンをクリックしたときのリスナーを設定する
        playStop.setOnClickListener {
            timer.isRunning = when(timer.isRunning) {
                true -> { // カウントダウン中の場合
                    timer.cancel() // カウントダウン停止
                    // 画像をプレイマークに変更する
                    playStop.setImageResource(
                        R.drawable.ic_play_arrow_black_24dp
                    )
                    false
                }
                false -> { // 停止中の場合
                    timer.start() // カウントダウン開始
                    // 画像をストップマークに変更する
                    playStop.setImageResource(
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
        soundPool =
            if (Build.VERSION.SDK_INT < Build.VERSION_CODES.LOLLIPOP) {
                // SoundPoolクラスのインスタンスを作成する（非推奨）
                SoundPool(2, AudioManager.STREAM_ALARM, 0)
            } else {
                val audioAttributes = AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_ALARM)
                    .build()
                SoundPool.Builder()
                    .setMaxStreams(1)
                    .setAudioAttributes(audioAttributes)
                    .build()
            }

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
