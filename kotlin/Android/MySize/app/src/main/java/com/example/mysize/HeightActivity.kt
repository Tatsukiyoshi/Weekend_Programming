package com.example.mysize

import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceManager
import android.view.View
import android.widget.AdapterView
import android.widget.RadioButton
import android.widget.SeekBar
import android.widget.Spinner
import com.example.mysize.databinding.ActivityHeightBinding
import androidx.core.content.edit as edit1

class HeightActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHeightBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeightBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        // スピナーの処理を実装
        binding.spinner.onItemSelectedListener =
                object : AdapterView.OnItemSelectedListener {

                    // 項目が選択された時の処理
                    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                        val spinner = parent as? Spinner
                        val item = spinner?.selectedItem as? String
                        item?.let {
                            if (it.isNotEmpty()) binding.height.text = it
                        }
                    }

                    // 項目が選択されずにビューが閉じられた時の処理
                    override fun onNothingSelected(parent: AdapterView<*>?) {

                    }
                }

        // シークバーの処理を追加する
        val pref: SharedPreferences? = PreferenceManager.getDefaultSharedPreferences(this)
        val heightVal = pref?.getInt("HEIGHT", 160)
        binding.height.text = heightVal.toString()
        if (heightVal != null) {
            binding.seekBar.progress = heightVal
        }

        binding.seekBar.setOnSeekBarChangeListener(
            object : SeekBar.OnSeekBarChangeListener {
                // シークバーの値を変更した時の処理
                override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                    binding.height.text = progress.toString()
                }

                // シークバーに触れた時の処理
                override fun onStartTrackingTouch(seekBar: SeekBar?) {
                }

                // シークバーを離した時の処理
                override fun onStopTrackingTouch(seekBar: SeekBar?) {
                }
            }
        )

        binding.radioGroup.setOnCheckedChangeListener {
                _, checkedId ->
            binding.height.text = findViewById<RadioButton>(checkedId).text
        }
    }

    override fun onPause() {
        super.onPause()
        val pref : SharedPreferences? = PreferenceManager.getDefaultSharedPreferences(this)
        val heightVal = binding.height.text.toString().toInt()
        pref?.edit1 {
            putInt("HEIGHT", heightVal)
        }
    }
}
