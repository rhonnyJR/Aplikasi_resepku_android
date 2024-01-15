package com.oki.responsiuts

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

class Adapter(context: Context, private val crypto: List<Simpan>) :
    ArrayAdapter<Simpan>(context, 0, crypto) {
    private val inflater: LayoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: inflater.inflate(R.layout.cell, parent, false)

        val crypImageView = view.findViewById<ImageView>(R.id.CryptoImageView)
        val crypTitleTextView = view.findViewById<TextView>(R.id.CryptoTitleTextView)

        val cryp = crypto[position]
        crypImageView.setImageResource(cryp.coverResourceId)
        crypTitleTextView.text = cryp.title

        return view
    }
}