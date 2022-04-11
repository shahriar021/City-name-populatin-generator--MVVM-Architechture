package com.example.mvvmcities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.content.res.ResourcesCompat
import androidx.lifecycle.Observer
import com.example.mvvmcities.databinding.ActivityMainBinding
import com.example.mvvmcities.model.CityDataProvider
import com.example.mvvmcities.viewmodel.CityViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val model: CityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    override fun onResume() {
        super.onResume()

        model.getCityData().observe(this, Observer { city->
            binding.imageView.setImageDrawable(
                ResourcesCompat.getDrawable(resources,city.img,applicationContext.theme)
            )
            binding.citynameTV.text = city.name
            binding.citypopulation.text=city.population.toString()
        })

    }
}