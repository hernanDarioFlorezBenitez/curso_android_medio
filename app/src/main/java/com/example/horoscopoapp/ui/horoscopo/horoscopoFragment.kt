package com.example.horoscopoapp.ui.horoscopo

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.horoscopoapp.databinding.FragmentHoroscopoBinding
import com.example.horoscopoapp.domain.model.HoroscopoModel
import com.example.horoscopoapp.domain.model.horoscopoInf
import com.example.horoscopoapp.domain.model.horoscopoInf.*
import com.example.horoscopoapp.ui.horoscopo.adapter.HoroscopoAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class horoscopoFragment : Fragment() {

    private val horoscopoViewModel by viewModels<horoscopoViewModel>()

    private lateinit var horoscopoAdapter: HoroscopoAdapter

    private var _binding: FragmentHoroscopoBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initList()
        initUIState()
    }

    private fun initList() {
        horoscopoAdapter = HoroscopoAdapter(onItemSelected = {
           val type = when(it){
                Aquario ->HoroscopoModel.Aquario
                Aries -> HoroscopoModel.Aries
                Cancer -> HoroscopoModel.Cancer
                Capricornio -> HoroscopoModel.Capricornio
                Geminis -> HoroscopoModel.Geminis
                Leo -> HoroscopoModel.Leo
                Libra -> HoroscopoModel.Libra
                Piscis -> HoroscopoModel.Piscis
                Sagitario -> HoroscopoModel.Sagitario
                Scorpio -> HoroscopoModel.Scorpio
                Tauro -> HoroscopoModel.Tauro
                Virgo -> HoroscopoModel.Virgo
            }

            findNavController().navigate(
                 horoscopoFragmentDirections.actionHoroscopoFragmentToDetailActivity(type)
            )
        })

        binding.rvHoroscopo.apply {
            layoutManager = GridLayoutManager(context, 2)
            adapter = horoscopoAdapter
        }

        // binding.rvHoroscopo.layoutManager = LinearLayoutManager(requireContext()) //forma sin renderizar
        //binding.rvHoroscopo.adapter = adapter //forma sin renderizar
    }

    private fun initUIState() {
        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                horoscopoViewModel.horoscopo.collect {
                    // CAMBIOS EN HOROSCOPO
                    //Log.i("dario",it.toString() )
                    horoscopoAdapter.updateList(it)
                }
            }
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentHoroscopoBinding.inflate(layoutInflater, container, false)
        return binding.root
    }


}