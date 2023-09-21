package com.example.horoscopoapp.ui.horoscopo.adapter

import android.view.View
import android.view.animation.LinearInterpolator
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.databinding.ItemHoroscopoBinding
import com.example.horoscopoapp.domain.model.horoscopoInf

class HoroscopoViewHolder(view:View):RecyclerView.ViewHolder(view) {

    private val binding = ItemHoroscopoBinding.bind(view)
    fun render(horoscopoInf: horoscopoInf, onItemSelected: (horoscopoInf) -> Unit){

        val context = binding.tvTitle.context    //variable para psar contesco a texto que deve pasar como string

        binding.ivHoroscopo.setImageResource(horoscopoInf.img)
        binding.tvTitle.text = context.getString(horoscopoInf.name)

        binding.parent.setOnClickListener {
            startRotationAnimation(binding.ivHoroscopo, newLambda = {onItemSelected(horoscopoInf)})
            onItemSelected(horoscopoInf)
        }
    }

    private fun startRotationAnimation(view: View, newLambda:()->Unit){
        view.animate().apply {
            duration = 500
            interpolator = LinearInterpolator()
            rotationBy(360f)
            withEndAction(){ newLambda()}
            start()
        }
    }
}