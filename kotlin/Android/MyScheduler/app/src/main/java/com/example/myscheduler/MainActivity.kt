package com.example.myscheduler

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myscheduler.databinding.ActivityMainBinding
import com.example.myscheduler.databinding.ContentMainBinding
import io.realm.Realm
import io.realm.kotlin.where

class MainActivity : AppCompatActivity() {
    private lateinit var realm: Realm
    private lateinit var binding: ActivityMainBinding
    private lateinit var contentBinding: ContentMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        var view = binding.root
        setContentView(view)
        setSupportActionBar(binding.toolbar)
        realm = Realm.getDefaultInstance()
        contentBinding = ContentMainBinding.inflate(layoutInflater)

        // RecyclerView にアダプターとレイアウトマネージャを設定する
        contentBinding.list.layoutManager = LinearLayoutManager(this)
        val schedules = realm.where<Schedule>().findAll()
        val adapter = ScheduleAdapter(schedules)
        contentBinding.list.adapter = adapter

        // Parameter 'view' is never used, could be renamed to _
        //fab.setOnClickListener { view ->
        binding.fab.setOnClickListener { _ ->
            val intent = Intent(this, ScheduleEditFragment::class.java)
            startActivity(intent)
        }

        // コールバックを実装し、画面遷移を行う
        adapter.setOnItemClickListener {id ->
            val intent = Intent(this, ScheduleEditFragment::class.java)
                .putExtra("schedule_id", id)
            startActivity(intent)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        realm.close()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when(item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }
}
