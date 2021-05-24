package com.example.vismahomework.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitService {
    private const val WEATHER_URL = "http://api.openweathermap.org/data/2.5/"

    private val retrofit = Retrofit.Builder().baseUrl(WEATHER_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun <T> buildService(serviceType: Class<T>): T {
        return retrofit.create(serviceType)
    }
}