package com.oki.responsiuts

import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.hardware.Sensor
import android.hardware.SensorEvent
import android.hardware.SensorEventListener
import android.hardware.SensorManager
import android.net.Uri
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

class Deskripsi : AppCompatActivity() {
    private var mBtn_menus1: Button? = null
    private var mBtn_menus2: Button? = null

    private lateinit var sensorManager: SensorManager
    private lateinit var rotationVectorSensor: Sensor
    private lateinit var rvListener: SensorEventListener
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_deskripsi)
        sensorManager = getSystemService(Context.SENSOR_SERVICE) as SensorManager

        // Mendapatkan referensi ke Rotation Vector Sensor
        rotationVectorSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ROTATION_VECTOR)!!

        // Memastikan sensor tersedia sebelum mendaftarkan listener
        if (rotationVectorSensor != null) {
            // Membuat listener untuk Rotation Vector Sensor
            rvListener = object : SensorEventListener {
                override fun onSensorChanged(sensorEvent: SensorEvent) {
                    // Handler perubahan data sensor
                    val rotationMatrix = FloatArray(9)
                    SensorManager.getRotationMatrixFromVector(rotationMatrix, sensorEvent.values)

                    // Menghitung sudut rotasi (contoh: sudut pitch)
                    val orientationValues = FloatArray(3)
                    SensorManager.getOrientation(rotationMatrix, orientationValues)
                    val pitch = Math.toDegrees(orientationValues[1].toDouble()).toFloat()

                    // Mengubah warna latar belakang berdasarkan nilai pitch
                    changeBackgroundColor(pitch)
                }

                override fun onAccuracyChanged(sensor: Sensor, accuracy: Int) {
                    // Handler perubahan akurasi sensor
                }
            }

            // Mendaftarkan listener untuk Rotation Vector Sensor
            sensorManager.registerListener(
                rvListener,
                rotationVectorSensor,
                SensorManager.SENSOR_DELAY_NORMAL
            )
        } else {
            // Sensor tidak tersedia pada perangkat ini
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        // Menghentikan penerimaan data sensor saat activity dihancurkan
        sensorManager.unregisterListener(rvListener)
    }

    private fun changeBackgroundColor(pitch: Float) {
        val rootView = window.decorView.rootView

        // Mengubah warna latar belakang berdasarkan nilai pitch
        val backgroundColor = when {
            pitch > 45 -> Color.RED
            pitch < -45 -> Color.WHITE
            else -> Color.YELLOW
        }

        rootView.setBackgroundColor(backgroundColor)

        val selectedBook: Simpan? = intent.getParcelableExtra(SELECTED)

        // Contoh pengaturan tampilan detail crypto
        val crypTitleTextView = findViewById<TextView>(R.id.judul)
        val crypAuthorTextView = findViewById<TextView>(R.id.deskripsi)
        val crypHistory = findViewById<TextView>(R.id.sejarah)
        val crypImageView = findViewById<ImageView>(R.id.img_kripto)


        crypTitleTextView.text = selectedBook?.title
        crypAuthorTextView.text = selectedBook?.description
        crypHistory.text = selectedBook?.history
        crypImageView.setImageResource(selectedBook?.coverResourceId ?: R.drawable.nasigoreng)
        
        mBtn_menus1 = findViewById<View>(R.id.btn_menus1) as Button
        mBtn_menus1!!.setOnClickListener {
            val iMenu1 = Intent(
                applicationContext,
                nasgor::class.java
            )
            startActivity(iMenu1)
        }

    mBtn_menus2 = findViewById<View>(R.id.btn_menus2) as Button
    mBtn_menus2!!.setOnClickListener {
        val iMenu2 = Intent(
            applicationContext,
            GridView::class.java
        )
        startActivity(iMenu2)
    }
}

        companion object {
        const val SELECTED = "extra_selected_book"
    }
}