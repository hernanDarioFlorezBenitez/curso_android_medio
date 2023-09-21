package com.example.horoscopoapp.ui.datail

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.navigation.navArgs
import com.example.horoscopoapp.R
import com.example.horoscopoapp.databinding.ActivityDetailBinding
import com.example.horoscopoapp.databinding.ActivityMainBinding
import com.example.horoscopoapp.databinding.FragmentLuckBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val horoscopoDitailViewModel:HoroscopoDitailViewModel by viewModels()

    private val args:DetailActivityArgs by navArgs()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)
        args.type
    }
}