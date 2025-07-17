package com.example.ma_codereading.data

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Profile(
    val name: String,
    val age: Int
) : Parcelable