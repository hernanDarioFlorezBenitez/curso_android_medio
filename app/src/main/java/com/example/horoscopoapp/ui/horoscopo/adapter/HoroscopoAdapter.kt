package com.example.horoscopoapp.ui.horoscopo.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.horoscopoapp.R
import com.example.horoscopoapp.domain.model.horoscopoInf

class HoroscopoAdapter(private var horoscopoList: List<horoscopoInf> = emptyList(),
    private val onItemSelected:(horoscopoInf)-> Unit) :
    RecyclerView.Adapter<HoroscopoViewHolder>() {

    fun updateList(list:List<horoscopoInf>) {
        horoscopoList = list
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HoroscopoViewHolder {
        return HoroscopoViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.item_horoscopo, parent, false)
        )
    }

    override fun getItemCount() = horoscopoList.size

    override fun onBindViewHolder(holder: HoroscopoViewHolder, position: Int) {
        holder.render(horoscopoList[position], onItemSelected)
    }
}