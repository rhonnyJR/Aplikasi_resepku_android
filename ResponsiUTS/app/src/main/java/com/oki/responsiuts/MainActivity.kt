package com.oki.responsiuts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private var mBtn_menu1: Button? = null
    private var mBtn_menu2: Button? = null
    private var mBtn_menu3: Button? = null
    private lateinit var mBtn_exit: Button  // tombol keluar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //inisial tombol
        mBtn_menu1 = findViewById<View>(R.id.btn_menu1) as Button //inisialisasi tombol list crypto
        mBtn_menu2 = findViewById<View>(R.id.btn_menu2) as Button //inisialisasi tombol profil
        mBtn_menu3 = findViewById<View>(R.id.btn_menu3) as Button
        mBtn_exit = findViewById<Button>(R.id.btn_exit)  // inisialisasi tombol keluar
        // function tombol list crypto
        mBtn_menu1!!.setOnClickListener {
            val iMenu1 = Intent(
                applicationContext,
                GridView::class.java
            )
            startActivity(iMenu1)
        }
        // function tombol profil
        mBtn_menu2!!.setOnClickListener {
            val iMenu2 = Intent(
                applicationContext,
                Profile::class.java
            )
            startActivity(iMenu2)
        }

        mBtn_menu3!!.setOnClickListener {
            val iMenu3 = Intent(
                applicationContext,
               info::class.java
            )
            startActivity(iMenu3)
        }
        // fungsi tombol keluar
        mBtn_exit.setOnClickListener {
            finishAffinity()  // menutup semua activity dan keluar dari aplikasi
        }
    }
}