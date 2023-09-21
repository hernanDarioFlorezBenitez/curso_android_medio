package com.example.horoscopoapp.data.providers

import com.example.horoscopoapp.domain.model.horoscopoInf
import com.example.horoscopoapp.domain.model.horoscopoInf.*
import javax.inject.Inject

class HoroscopoProviders @Inject constructor(){
    fun getHoroscopos():List<horoscopoInf>{
        return listOf(
            Aries,
            Tauro,
            Geminis,
            Cancer,
            Leo,
            Virgo,
            Libra,
            Scorpio,
            Sagitario,
            Capricornio,
            Aquario,
            Piscis,
        )
    }
}