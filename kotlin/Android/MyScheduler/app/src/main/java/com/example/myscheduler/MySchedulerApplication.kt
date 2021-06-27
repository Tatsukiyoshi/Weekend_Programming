package com.example.myscheduler

import android.app.Application
import io.realm.Realm

class MySchedulerApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        // データベース設定処理
        Realm.init(this)
    }
}