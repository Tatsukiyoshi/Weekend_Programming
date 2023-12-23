package com.example.myalarmclock

import android.app.AlarmManager
import android.app.KeyguardManager
import android.app.PendingIntent.*
import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import android.text.format.DateFormat
import com.example.myalarmclock.databinding.ActivityMainBinding
import java.lang.IllegalArgumentException
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity(), TimeAlertDialog.Listener,
    DatePickerFragment.OnDateSelectedListener,
    TimePickerFragment.OnTimeSelectedListener {

    private lateinit var binding: ActivityMainBinding
    override fun onSelected(year: Int, month: Int, date: Int) {
        val c = Calendar.getInstance()
        c.set(year, month, date)
        binding.dateText.text = DateFormat.format("yyyy/MM/dd", c)
    }

    override fun onSelected(hourOfDay: Int, minute: Int) {
        binding.timeText.text = getString(R.string.timeTextFormat).format(hourOfDay, minute)
    }

    override fun getUp() {
    //  Toast.makeText(this, "起きるがクリックされました", Toast.LENGTH_SHORT)
    //      .show()
        finish()
    }

    override fun snooze() {
    //  Toast.makeText(this, "あと５分がクリックされました", Toast.LENGTH_SHORT)
    //      .show()
        val calendar = Calendar.getInstance()
        calendar.timeInMillis = System.currentTimeMillis()
        calendar.add(Calendar.MINUTE, 5)
        setAlarmManager(calendar)
        finish()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        if (intent?.getBooleanExtra("onReceive", false) == true) {
            // スリープ解除も画面を表示する
            this.setShowWhenLocked(true)
            setTurnScreenOn(true)
            val keyguardManager =
                getSystemService(Context.KEYGUARD_SERVICE) as KeyguardManager
            keyguardManager.requestDismissKeyguard(this, null)

            val dialog = TimeAlertDialog()
            dialog.show(supportFragmentManager, "alert_dialog")
        }

        binding.setAlarm.setOnClickListener {
            //val calendar = Calendar.getInstance()
            //calendar.timeInMillis = System.currentTimeMillis()
            //calendar.add(Calendar.SECOND, 5)
            //setAlarmManager(calendar)
            val date = "${binding.dateText.text} ${binding.timeText.text}".toDate()
            when {
                date != null -> {
                    val calendar = Calendar.getInstance()
                    calendar.time = date
                    setAlarmManager(calendar)
                    Toast.makeText(
                        this, "アラームをセットしました",
                        Toast.LENGTH_SHORT
                    ).show()
                }
                else -> {
                    Toast.makeText(
                        this, "日付の形式が正しくありません",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }

        binding.cancelAlarm.setOnClickListener {
            cancelAlarmManager()
        }

        binding.dateText.setOnClickListener {
            val dialog = DatePickerFragment()
            dialog.show(supportFragmentManager, "date_dialog")
        }

        binding.timeText.setOnClickListener {
            val dialog = TimePickerFragment()
            dialog.show(supportFragmentManager, "time_dialog")
        }
    }

    // アラームマネージャにイベントを登録する
    private fun setAlarmManager(calendar: Calendar) {
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmBroadcastReceiver::class.java)
        val pending = getBroadcast(this, 0, intent, FLAG_IMMUTABLE)

        am[AlarmManager.RTC_WAKEUP, calendar.timeInMillis] = pending
    }

    // キャンセル処理を追加する
    private fun cancelAlarmManager() {
        val am = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        val intent = Intent(this, AlarmBroadcastReceiver::class.java)
        val pending = getBroadcast(this, 0, intent, FLAG_IMMUTABLE)
        am.cancel(pending)
    }

    // 日付変換の拡張関数
    private fun String.toDate(pattern: String = "yyyy/mm/dd HH:mm"): Date? {
        return try {
            SimpleDateFormat(pattern, Locale.JAPAN).parse(this)
        } catch (e: IllegalArgumentException) {
            return null
        } catch (e: ParseException) {
            return null
        }
    }
}
