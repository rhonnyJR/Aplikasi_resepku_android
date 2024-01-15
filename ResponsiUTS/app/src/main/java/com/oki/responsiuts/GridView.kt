package com.oki.responsiuts

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.GridView
import androidx.appcompat.app.AppCompatActivity

class GridView : AppCompatActivity() {
    private var mBtn_menus: Button? = null
    private lateinit var GridView: GridView
    private lateinit var GridAdapter: Adapter


    private val isi = listOf(
        Simpan(
            "Nasi Goreng",
            "Bahan :\n" + "1 buah paha ayam atas bawah rebus, suwir ayamnya,\n" +
                    "2 buah telur, kocok lepas,\n" + "150 g udang tanpa kulit,\n" + "5 buah bakso sapi, potong-potong,\n"
                    + "5 buah bakso ikan, potong-potong,\n" + "500 g nasi putih,\n" + "2 sdm kecap manis Bango,\n"
                    + "1 sdt garam,\n" + "1/2 sdt gula pasir,\n" + "1 buah daun bawang, iris tipis,\n"
                    + "1 1/2 sdm bawang goreng untuk taburan,\n" + "3 sdm minyak goreng untuk menumis,\n" + "1 sdt terasi, bakar,\n"
                    + "3 buah cabai merah besar,\n" + "3 buah cabai merah keriting,\n" + "2 siung bawang putih,\n" + "6 butir bawang merah,\n"
                    + "3 buah telur ceplook.\n",
            "Cara Memasak :\n" + "1. Panaskan minyak. Tumis bumbu tumbuk kasar sampai harum. Sisihkan di pinggir wajan. Masukkan telur. Aduk sampai berbutir.\n" +
                    "2. Tambahkan ayam, udang, bakso. Aduk rata. Tambahkan nasi putih. Aduk- aduk. Masukkan KECAP MANIS BANGO, garam, dan gula pasir. Aduk sampai matang.\n" +
                    "3. Masukkan daun bawang. Aduk rata. Sajikan bersama telur ceplok dan taburan bawang merah goreng.",
            R.drawable.nasigoreng
        ),
        Simpan(
            "Semur Tuna",
            "Bahan :\n" + "500 gr ikan tuna segar fillet, dipotong agak besar,\n" +
                    "1 sendok teh air jeruk nipis,\n" + "1/2 sendok teh garam,\n" + "1 lembar daun kunyit,\n"
                    + "2 lembar daun pandan,\n" + "1/2 sendok teh garam,\n" + "1/4 sendok teh lada putih bubuk,\n"
                    + "3/4 sendok teh pala bubuk,\n" + "5 sendok makan Bango kecap manis,\n" + "400 ml air,\n"
                    + "1 buah tomat, dipotong-potong,\n" + "10 tangkai daun kemangi,\n" + "2 tangkai daun bawang, diiris dengan halus,\n"
                    + "2 sendok makan minyak goreng untuk menumis,\n" + "minyak goreng 200 ml untuk menggoreng,\n"
                    + "8 butir bawang merah,\n" + "3 siung bawang putih,\n" + "2 cm jahe.\n",
            "Cara Memasak :\n" + "Lumuri tuna dengan air jeruk dan garam. Diamkan 15 menit. Goreng di dalam minyak panas samapi berkulit. Sisihkan.\n" +
                    "Tumis bumbu halus sampai harum. Masukkan daun kunyit dan daun pandan. Aduk rata.\n" +
                    "Masukkan tuna. Aduk sampai tuna terbalut bumbu.\n" + "Bubuhi garam, lada putih bubuk, pala bubuk, dan Kecap Manis Bango. Aduk rata.\n"
                    + "Tuangkan air sedikit demi sedikit sambil direbus sampai bumbu meresap.\n" + "Masukkan tomat, kemangi, dan daun bawang. Aduk sampai layu. Angkat.\n",
            R.drawable.semurtuna
        ),
        Simpan(
            "Semur Betawi",
            "Bahan :\n" + "6 buah tahu kotak,\n" + "300 gr tempe potong dadu,\n" +
                    "3 buah kentang ukuran sedang, potong 2-3 bagian, goreng berkulit,\n" + "8 butir bawang merah, iris tipis,\n" +
                    "1 lembar daun salam,\n" + "1 buah tomat, potong-potong,\n" + "1/2 sendok teh pala bubuk,\n" + "2 butir cengkeh utuh,\n"
                    + "2 cm kayumanis,\n" + "200 ml Bango kecap manis,\n" + "1 sendok teh garam,\n" + "800 ml air,\n" + "2 sendok makan minyak untuk menumis,\n"
                    + "2 sendok makan bawang goreng untuk taburan,\n" + "6 butir kemiri, disangrai,\n" + " " + "5 siung bawang putih,\n" + "2 sendok teh ketumbar,\n"
                    + "1/8 sendok teh jintan putih bubuk",
            "Cara Memasak :\n" + "Panaskan minyak. Tumis bawang merah hingga harum. Masukkan bumbu halus dan daun salam. Aduk sampai harum.\n" +
                    "Masukkan tahu, tempe, kentang, dan tomat. Aduk rata.\n" + "Tambahkan pala bubuk, cengkeh, kayumanis, Kecap Manis, dan garam. Aduk rata.\n" +
                    "Tuang air secara bertahap. Masak hingga meresap. Sajikan dengan taburan bawang goreng",
            R.drawable.semurbetawi
        ),
        Simpan(
            "Cumi Goreng Tepung Saus Semur",
            "Bahan :\n" + "500 gr cumi-cumi, dipotong ring tebal 1cm,\n"
                    + "1/2 sendok teh garam,\n" + "1/4 sendok teh merica bubuk,\n" + "1/2 sendok teh minyak wijen,\n" + "500 ml minyak untuk menggoreng,\n" +
                    "100 gr tepung terigu,\n" + "1/2 sendok makan bawang putih bubuk,\n" + "1/2 sendok teh garam,\n" + "1/4 sendok teh merica bubuk,\n"
                    + "1/2 sendok teh gula pasir,\n" + "1/2 sendok teh baking powder,\n" + "200 ml air es,\n" + "300 gr tepung terigu,\n" + "2 sendok makan tepung sagu,\n"
                    + "1 sendok teh Royco kaldu ayam bubuk,\n" + "1 sendok teh garam,\n" + "1 sendok makan biji wijen,\n" + "4 butir bawang merah, iris tipis,\n" +
                    "1 lembar daun salam,\n" + "1/2 sendok teh pala bubuk,\n" + "1 butir cengkeh utuh,\n" + "1 cm kayumanis,\n" + "3 sendok makan kecap manis,\n" +
                    "1/8 sendok teh garam,\n" + "200 ml air,\n" + "1/2 sendok teh maizena dilarutkan ke dalam 1 sendok teh air,\n" + "1 sendok makan minyak untuk menumis,\n" +
                    "2 siung bawang putih,\n" + "2 butir kemiri, disangrai,\n" + "1/4 sendok teh ketumbar,\n" + "1/8 sendok teh jintan putih bubuk",
            "Cara Memasak :\n" + "Lumuri cumi dengan garam, merica bubuk, dan minyak wijen. Diamkan 20 menit.\n" + "Aduk rata bahan pencelup.\n"
                    + "Celup cumi ke bahan pencelup. Gulingkan di bahan pelapis yang sudah diayak sambil diangkat-angkat. Ulangi sekali lagi.\n" +
                    "Goreng dalam minyak yang sudah dipanaskan dengan api sedang sampai matang dan kering. Sisihkan.\n" + "Saus, panaskan minyak. Tumis bumbu halus, bawang merah, dan daun salam sampai harum.\n"
                    + "Masukkan pala bubuk, cengkeh, kayumanis, Kecap Manis Bango, dan garam. Tuang air. Kentalkan dengan larutan maizena. Masak hingga mendidih dan matang.\n"
                    + "Sajikan cumi bersama saus.",
            R.drawable.cumigoreng
        ),
        Simpan(
            "Telur Mata Sapi Tumis Cabe",
            "Bahan :\n" + "6 butir telur ayam,\n" + "2 siung bawang putih, diiris miring,\n"
                    + "4 butir bawang merah, diiris miring,\n" + "4 buah cabai hijau segar, diiris miring,\n" + "2 buah cabe merah keriting, diiris miring,\n"
                    + "1/2 sdm kecap asin,\n" + "2 sdm kecap manis,\n" + "2 sdt lada putih bubuk,\n" + "garam secukupnya,\n" + "1/2 sdt gula pasir,\n"
                    + "250 ml air,\n" + "1 tangkai daun bawang, iris kasar,\n" + "2 sdm minyak goreng untuk menumis",
            "Cara Memasak :\n" + "Ceplok telur satu per satu. Sisihkan.\n" +
                    "Panaskan minyak. Tumis bawang putih, bawang merah, cabe hijau, dan cabe merah sampai harum. Tambahkan telur ceplok. Aduk rata.\n" +
                    "Masukkan kecap asin, Kecap Manis Bango, lada putih bubuk, garam, dan gula pasir. Aduk rata.\n" + "Tuang air. Masak sampai meresap. Tambahkan daun bawang. Aduk rata.\n" +
                    "Sajikan",
            R.drawable.telurmata
        ),
        Simpan(
            "Semur Kentang",
            "Bahan :\n" + "150 gr tahu cokelat, potong dadu,\n" + "350 gr kentang, potong dadu,\n"
                    + "3 butir cengkeh utuh,\n" + "3 cm kayumanis,\n" + "5 sdm Bango kecap manis,\n" + "1 sdt garam,\n" + "1/2 sdt lada bubuk,\n"
                    + "1/2 sdt pala bubuk,\n" + "1 liter air,\n" + "3 sdm minyak goreng untuk menumis,\n" + "8 butir bawang merah,\n" + "6 siung bawang putih,\n" +
                    "1 sdm ketumbar",
            "Dengan menggunakan minyak banyak, goreng kentang dan tahu hingga matang. Angkat dan saring, sisihkan.\n" +
                    "Di dalam wajan, tumis bumbu halus, cengkeh dan kayu manis sampai harum. Masukkan tahu dan kentang, aduk rata.\n"
                    + "Masukkan air, Bango Kecap Manis, garam, lada bubuk dan pala bubuk. Masak sampai meresap dan matang dengan api sedang.",
            R.drawable.semurkentang
        )
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_grid_view)

        GridView = findViewById(R.id.KriptoGridView)
        GridAdapter = Adapter(this, isi)
        GridView.adapter = GridAdapter
        GridView.setOnItemClickListener { _, _, position, _ ->
            val selectedBook = isi[position]
            val intent = Intent(this, Deskripsi::class.java)
            intent.putExtra(Deskripsi.SELECTED, selectedBook)
            startActivity(intent)
        }


        mBtn_menus = findViewById<View>(R.id.btn_back) as Button
        mBtn_menus!!.setOnClickListener {
            val iMenu1 = Intent(
                applicationContext,
                MainActivity::class.java
            )
            startActivity(iMenu1)
        }
    }
}
