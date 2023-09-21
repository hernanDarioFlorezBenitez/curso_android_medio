package com.example.horoscopoapp.ui.horoscopo

import androidx.lifecycle.ViewModel
import com.example.horoscopoapp.data.providers.HoroscopoProviders
import com.example.horoscopoapp.domain.model.horoscopoInf
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class horoscopoViewModel @Inject constructor(horoscopoProviders: HoroscopoProviders) : ViewModel() {

    private var _horoscopo = MutableStateFlow<List<horoscopoInf>>(emptyList())
    val horoscopo: StateFlow<List<horoscopoInf>> = _horoscopo

    init {
        _horoscopo.value= horoscopoProviders.getHoroscopos()
    }
}