package com.example.universityfinder

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class WebviewActivity : AppCompatActivity() {
    private lateinit var webView: WebView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_webview)
        webView = findViewById(R.id.webView)


        val url = intent.getStringExtra("url") ?: ""


        if (url.isNotEmpty()) {
            webView.settings.javaScriptEnabled = true
            webView.webViewClient = WebViewClient() // Ensures links open in the WebView, not a browser
            webView.loadUrl(url)
        }
    }
}