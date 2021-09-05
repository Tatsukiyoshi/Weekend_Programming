package com.example.myscheduler

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import java.lang.IllegalArgumentException
import android.text.format.DateFormat
import com.example.myscheduler.databinding.ActivityScheduleEditBinding
//import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ScheduleEditActivity : AppCompatActivity() {
    // 保存ボタンタップ時の処理
    private lateinit var realm: Realm
    private lateinit var binding: ActivityScheduleEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScheduleEditBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // 保存ボタンタップ時の処理
        realm = Realm.getDefaultInstance()

        // 更新処理を実装する
        val scheduleId = intent?.getLongExtra("schedule_id", -1L)
        if (scheduleId != -1L) {
            val schedule = realm.where<Schedule>()
                .equalTo("id", scheduleId).findFirst()
            binding.dateEdit.setText(DateFormat.format("yyyy/mm/dd", schedule?.date))
            binding.titleEdit.setText(schedule?.title)
            binding.detailEdit.setText(schedule?.detail)

            // ビューの表示制御
            binding.delete.visibility = View.VISIBLE
        } else {
            binding.delete.visibility = View.INVISIBLE
        }

        binding.save.setOnClickListener { wview: View ->
            // executeTransaction でトランザクションの開始、終了、キャンセル処理は自動！
            when(scheduleId) {
                -1L -> {
                    realm.executeTransaction { db: Realm ->
                        val maxId = db.where<Schedule>().max("id")
                        val nextId = (maxId?.toLong() ?: 0L) + 1
                        val schedule = db.createObject<Schedule>(nextId)
                        val date = binding.dateEdit.text.toString().toDate("yyyy/mm/dd")
                        if (date != null) schedule.date = date
                        schedule.title = binding.titleEdit.text.toString()
                        schedule.detail = binding.detailEdit.text.toString()
                    }
                    Snackbar.make(wview, "追加しました", Snackbar.LENGTH_SHORT)
                        .setAction("戻る") { finish() }
                        .setActionTextColor(Color.YELLOW)
                        .show()
                }
                else -> {
                    realm.executeTransaction { db: Realm ->
                        val schedule = db.where<Schedule>()
                            .equalTo("id", scheduleId).findFirst()
                        val date = binding.dateEdit.text.toString()
                            .toDate("yyyy/mm/dd")
                        if (date != null) schedule?.date = date
                        schedule?.title = binding.titleEdit.text.toString()
                        schedule?.detail = binding.detailEdit.text.toString()
                    }
                    Snackbar.make(wview, "修正しました", Snackbar.LENGTH_SHORT)
                        .setAction("戻る") { finish() }
                        .setActionTextColor(Color.YELLOW)
                        .show()
                }
            }
        }

        // 削除処理を実装する
        binding.delete.setOnClickListener { wview: View ->
            realm.executeTransaction { db: Realm ->
                db.where<Schedule>().equalTo("id", scheduleId)
                    ?.findFirst()
                    ?.deleteFromRealm()
            }
            Snackbar.make(wview, "削除しました", Snackbar.LENGTH_SHORT)
                .setAction("戻る") { finish() }
                .setActionTextColor(Color.YELLOW)
                .show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    // Date 未解決でコンパイルエラー（Date は Java.util.Date ！）
    private fun String.toDate(pattern: String = "yyyy/mm/dd HH:mm") : Date? {
        return try {
            SimpleDateFormat(pattern,Locale.JAPAN).parse(this)
        } catch (e: IllegalArgumentException) {
            return null
        } catch (e: ParseException) {
            return null
        }
    }
}
