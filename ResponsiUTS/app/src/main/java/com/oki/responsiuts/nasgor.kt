package com.oki.responsiuts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebChromeClient
import android.webkit.WebView
import android.webkit.WebViewClient
import android.Manifest
import android.content.pm.PackageManager
import android.webkit.WebResourceRequest
import android.widget.Toast
import com.google.zxing.Result
import me.dm7.barcodescanner.zxing.ZXingScannerView


class nasgor : AppCompatActivity(),ZXingScannerView.ResultHandler {

    private lateinit var scannerView: ZXingScannerView
    private lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nasgor)

        scannerView = findViewById(R.id.scannerView)
        webView = findViewById(R.id.webView)
        webView.webViewClient = WebViewClient()

        scannerView.setResultHandler(this)
        scannerView.startCamera()
    }

    override fun handleResult(result: com.google.zxing.Result?) {
        // Handle barcode result
        val barcodeValue = result?.text

        if (barcodeValue != null) {
            openUrlInWebView(barcodeValue)
        }
    }

    private fun openUrlInWebView(url: String) {
        scannerView.stopCamera() // Stop the camera before showing WebView

        supportActionBar?.hide()

        // Load URL in WebView
        webView.loadUrl(url)
        webView.visibility = android.view.View.VISIBLE

        // Set WebViewClient untuk mendeteksi kapan halaman selesai dimuat
        webView.webViewClient = object : WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                // Setelah halaman selesai dimuat, tampilkan ActionBar
                supportActionBar?.show()
            }
        }
    }

    override fun onResume() {
        super.onResume()
        scannerView.setResultHandler(this)
        scannerView.startCamera()
    }

    override fun onPause() {
        super.onPause()
        scannerView.stopCamera()
    }
}