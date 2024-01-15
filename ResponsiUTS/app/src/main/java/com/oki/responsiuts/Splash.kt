package com.oki.responsiuts

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

class Splash : AppCompatActivity() {

    private var progressBar: ProgressBar? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_activity)

        progressBar = findViewById(R.id.progressBar)
        progressBar!!.max = 100 // Atur nilai maksimum progress bar

        // Mulai countdown timer selama 10 detik (10000 milidetik)
        object : CountDownTimer(10000, 100) {
            override fun onTick(millisUntilFinished: Long) {
                // Perbarui progress bar
                val progress = ((10000 - millisUntilFinished) / 100).toInt()
                progressBar!!.progress = progress
            }

            override fun onFinish() {
                progressBar!!.progress = 100 // Selesaikan progress bar

                // Intent untuk berpindah ke MainActivity setelah ProgressBar selesai
                val intent = Intent(this@Splash, MainActivity::class.java)
                startActivity(intent)
                finish()
            }
        }.start()
    }
}
