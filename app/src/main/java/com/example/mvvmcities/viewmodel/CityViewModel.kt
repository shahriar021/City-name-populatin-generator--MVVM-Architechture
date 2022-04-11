package com.example.mvvmcities.viewmodel

import android.os.Looper
import android.os.Looper.getMainLooper
import android.os.Looper.loop
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmcities.model.City
import com.example.mvvmcities.model.CityDataProvider
import android.os.Handler
import androidx.lifecycle.LiveData

class CityViewModel: ViewModel() {
    private val cityData =MutableLiveData<City>()
    private val cities = CityDataProvider().getCities()
    private var currentIndex =0
    private val delay = 2000L

    init {
        loop()
    }

    fun getCityData(): LiveData<City> =cityData

    private fun loop(){
        Handler(Looper.getMainLooper()).postDelayed({updataCity()},delay)
    }

    private fun updataCity(){
        currentIndex++
        currentIndex %= cities.size

        cityData.value = cities[currentIndex]
        loop()
    }
}