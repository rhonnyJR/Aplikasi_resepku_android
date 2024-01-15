package com.oki.responsiuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class info : AppCompatActivity() {
    private lateinit var Kembali: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_info)
        Kembali = findViewById(R.id.bt_back)





        Kembali.setOnClickListener {
            val iBack = Intent(applicationContext, MainActivity::class.java)
            startActivity(iBack)
            finish()
        }
    }
}