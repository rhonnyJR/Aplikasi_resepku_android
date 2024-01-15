package com.oki.responsiuts

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Simpan(
    val title: String,
    val description: String,
    val history: String,
    val coverResourceId: Int
) : Parcelable

