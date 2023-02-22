package com.example.movieapp.model

import androidx.annotation.DrawableRes
import androidx.annotation.IdRes
import androidx.annotation.IntegerRes
import androidx.annotation.StringRes

data class Affirmation(@StringRes val stringResourceId: Int,@DrawableRes val imageResourceId: Int, val puan: Double, val tarih: Int, val sure: String )
