package com.example.sainttropez

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

@Suppress("NULLABILITY_MISMATCH_BASED_ON_JAVA_ANNOTATIONS")
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // HTMLファイルを表示する
        webView.settings.javaScriptEnabled = true
        webView.loadUrl("file:///android_asset/html/index.html")

        // コンテキストメニューの登録
        registerForContextMenu(webView)
    }

    // メニューの作成
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.top -> {
                webView.loadUrl("file:///android_asset/html/index.html")
                return true
            }
            R.id.lunch01 -> {
                webView.loadUrl("file:///android_asset/html/lunch01.html")
                return true
            }
            R.id.lunch02 -> {
                webView.loadUrl("file:///android_asset/html/lunch02.html")
                return true
            }
            R.id.dinner01 -> {
                webView.loadUrl("file:///android_asset/html/dinner01.html")
                return true
            }
            R.id.dinner02 -> {
                webView.loadUrl("file:///android_asset/html/dinner02.html")
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }

    // コンテキストメニューが表示されるとき
    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.context, menu)
    }

    // コンテキストメニューが選択されたとき
    override fun onContextItemSelected(item: MenuItem): Boolean {
        when(item.itemId) {
            R.id.sms -> {               // SMSで予約
                val number = "999-9999-9999"
                val uri = Uri.parse("sms:$number")
                var intent = Intent(Intent.ACTION_VIEW)
                intent.data = uri
                startActivity(intent)
                return true
            }
            R.id.mail -> {              // メールで予約
                val email = "nobady@example.com"
                val subject = "予約問い合わせ"
                val text = "以下のとおり予約希望します"
                val uri = Uri.parse("mailto:")
                val intent = Intent(Intent.ACTION_SENDTO)
                intent.data = uri
                intent.putExtra(Intent.EXTRA_EMAIL, arrayOf(email))
                    .putExtra(Intent.EXTRA_SUBJECT, subject)
                    .putExtra(Intent.EXTRA_TEXT, text)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
            R.id.share -> {             // 共有する
                val text = "美味しいレストランを紹介します。"
                val intent = Intent(Intent.ACTION_SEND)
                intent.type = "text/plain"
                intent.putExtra(Intent.EXTRA_TEXT, text)
                val chooser = Intent.createChooser(intent, null)
                if (intent.resolveActivity(packageManager) != null) startActivity(chooser)
                return true
            }
            R.id.browse -> {            // ブラウザで開く
                val url: String = "http://www.yahoo.co.jp"
                val intent = Intent(Intent.ACTION_VIEW)
                intent.data = Uri.parse(url)
                if (intent.resolveActivity(packageManager) != null) {
                    startActivity(intent)
                }
                return true
            }
        }
        return super.onContextItemSelected(item)
    }
}
