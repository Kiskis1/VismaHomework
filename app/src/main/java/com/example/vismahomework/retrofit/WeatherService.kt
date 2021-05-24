package com.example.vismahomework.retrofit

import com.example.vismahomework.models.WeatherBase
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherService {
    @GET("weather?appid=7587eaff3affbf8e56a81da4d6c51d06&units=metric")
    fun getWeather(@Query("q") city: String): Call<WeatherBase>
}