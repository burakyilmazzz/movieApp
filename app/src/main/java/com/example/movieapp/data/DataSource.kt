package com.example.movieapp.data

import android.annotation.SuppressLint
import com.example.movieapp.R
import com.example.movieapp.model.Affirmation

class DataSource() {
    @SuppressLint("ResourceType")
    fun loadAffirmations(): List<Affirmation>{
        return listOf<Affirmation>(
            Affirmation(R.string.batman, R.drawable.batman, 8.9, 2011, "2h 30m" ),
            Affirmation(R.string.fightClub, R.drawable.fightclub, 8.8, 1999, "2h 45m"),
            Affirmation(R.string.baba, R.drawable.baba, 9.1, 1976 , "3h 12m"),
            Affirmation(R.string.yildizlararasi, R.drawable.yldzlararas, 8.7, 2014, "3h 02m"),
            Affirmation(R.string.lalaland, R.drawable.la_la_land, 7.9, 2016, "2h 59m"),
            Affirmation(R.string.bladeRunner, R.drawable.bladerunner,8.1,2015,"2h 37m")
        )

    }
}