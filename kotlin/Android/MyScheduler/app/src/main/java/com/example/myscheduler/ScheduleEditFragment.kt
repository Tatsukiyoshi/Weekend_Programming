package com.example.myscheduler

import android.graphics.Color
import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.google.android.material.snackbar.Snackbar
import io.realm.Realm
import io.realm.kotlin.createObject
import io.realm.kotlin.where
import java.lang.IllegalArgumentException
import android.text.format.DateFormat
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.myscheduler.databinding.ActivityScheduleEditBinding
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

class ScheduleEditFragment : Fragment() {
    private var _binding: ActivityScheduleEditBinding? = null
    private val binding get() = _binding!!

    private lateinit var realm: Realm

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        realm = Realm.getDefaultInstance()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = ActivityScheduleEditBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    private val args: ScheduleEditFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        if (args.scheduleId != -1L) {
            val schedule = realm.where<Schedule>()
                .equalTo("id", args.scheduleId).findFirst()
            binding.dateEdit.setText(DateFormat.format("yyyy/mm/dd", schedule?.date))
            binding.titleEdit.setText(schedule?.title)
            binding.detailEdit.setText(schedule?.detail)

            // ビューの表示制御
            binding.delete.visibility = View.VISIBLE
        } else {
            binding.delete.visibility = View.INVISIBLE
        }

        (activity as? MainActivity)?.setFavVisible(View.INVISIBLE)

        binding.save.setOnClickListener {
            val dialog = ConfirmDialog("保存しますか？",
                "保存",
                { saveSchedule(it) },
                "キャンセル", {
                    Snackbar.make(it, "キャンセルしました", Snackbar.LENGTH_SHORT).show()
            })
            dialog.show(parentFragmentManager, "save_dialog")
        }

        binding.delete.setOnClickListener {
            val dialog = ConfirmDialog("削除しますか？",
                "削除",
                { deleteSchedule(it) },
                "キャンセル", {
                    Snackbar.make(it, "キャンセルしました", Snackbar.LENGTH_SHORT).show()
                })
            dialog.show(parentFragmentManager, "delete_dialog")
        }
    }

    private fun saveSchedule(view: View) {
        // executeTransactionAsync でトランザクションの開始、終了、キャンセル処理は自動！
        when (args.scheduleId) {
            -1L -> {
                realm.executeTransactionAsync { db: Realm ->
                    val maxId = db.where<Schedule>().max("id")
                    val nextId = (maxId?.toLong() ?: 0L) + 1
                    val schedule = db.createObject<Schedule>(nextId)
                    val date = binding.dateEdit.text.toString().toDate("yyyy/mm/dd")
                    if (date != null) schedule.date = date
                    schedule.title = binding.titleEdit.text.toString()
                    schedule.detail = binding.detailEdit.text.toString()
                }
                Snackbar.make(view, "追加しました", Snackbar.LENGTH_SHORT)
                    .setAction("戻る") { findNavController().popBackStack() }
                    .setActionTextColor(Color.YELLOW)
                    .show()
            }
            else -> {
                realm.executeTransactionAsync { db: Realm ->
                    val schedule = db.where<Schedule>()
                        .equalTo("id", scheduleId).findFirst()
                    val date = binding.dateEdit.text.toString()
                        .toDate("yyyy/mm/dd")
                    if (date != null) schedule?.date = date
                    schedule?.title = binding.titleEdit.text.toString()
                    schedule?.detail = binding.detailEdit.text.toString()
                }
                Snackbar.make(workView, "修正しました", Snackbar.LENGTH_SHORT)
                    .setAction("戻る") { finish() }
                    .setActionTextColor(Color.YELLOW)
                    .show()
            }
        }
    }

    // 削除処理を実装する
    private fun deleteSchedule(view: View){
        realm.executeTransactionAsync { db: Realm ->
            db.where<Schedule>().equalTo("id", args.scheduleId)
                ?.findFirst()
                ?.deleteFromRealm()
        }
        Snackbar.make(view, "削除しました", Snackbar.LENGTH_SHORT)
            .setActionTextColor(Color.YELLOW)
            .show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
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
