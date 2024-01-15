package com.oki.responsiuts

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class Profile : AppCompatActivity() {
    private lateinit var Kembali: Button
    private lateinit var Nama: TextView
    private lateinit var NRP: TextView
    private lateinit var Email: TextView
    private lateinit var tvPhone: TextView
    private lateinit var tvJenisKelamin: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.profil)

        Kembali = findViewById(R.id.bt_back)





        Kembali.setOnClickListener {
            val iBack = Intent(applicationContext, MainActivity::class.java)
            startActivity(iBack)
            finish()
        }
    }
}