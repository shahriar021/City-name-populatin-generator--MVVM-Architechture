package com.example.mvvmcities.model

import com.example.mvvmcities.R

class CityDataProvider {
    private val cities = arrayListOf<City>()

    init {
        cities.add(City("DHAKA", R.drawable.dhaka,22_478_116))
        cities.add(City("SYLHET", R.drawable.sylhet,928_000))
        cities.add(City("CHITTAGONG", R.drawable.chittagong,8_440_000))
        cities.add(City("BARISAL", R.drawable.barisal,516_299))
    }

    fun getCities()=cities
}