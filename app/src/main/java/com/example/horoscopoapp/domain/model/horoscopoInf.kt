package com.example.horoscopoapp.domain.model

import com.example.horoscopoapp.R

sealed class horoscopoInf(val img:Int, val name:Int){
    data object Aries:horoscopoInf(R.drawable.aries, R.string.aries)
    data object Tauro:horoscopoInf(R.drawable.tauro, R.string.tauro)
    data object Geminis:horoscopoInf(R.drawable.geminis, R.string.geminis)
    data object Cancer:horoscopoInf(R.drawable.cancer, R.string.cancer)
    data object Leo:horoscopoInf(R.drawable.leo, R.string.leo)
    data object Virgo:horoscopoInf(R.drawable.virgo, R.string.virgo)
    data object Libra:horoscopoInf(R.drawable.libra, R.string.libra)
    data object Scorpio:horoscopoInf(R.drawable.escorpio, R.string.scorpio)
    data object Sagitario:horoscopoInf(R.drawable.sagitario, R.string.sagitario)
    data object Capricornio:horoscopoInf(R.drawable.capricornio, R.string.capricornio)
    data object Aquario:horoscopoInf(R.drawable.aquario, R.string.aquario)
    data object Piscis:horoscopoInf(R.drawable.piscis, R.string.piscis)
}