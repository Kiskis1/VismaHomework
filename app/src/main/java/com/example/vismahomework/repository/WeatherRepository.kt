package com.example.vismahomework.repository

import com.example.vismahomework.db.dao.WeatherDao
import com.example.vismahomework.models.WeatherBase
import com.example.vismahomework.retrofit.RetrofitService
import com.example.vismahomework.retrofit.WeatherService
import kotlinx.coroutines.flow.Flow
import retrofit2.Callback
import javax.inject.Inject

class WeatherRepository @Inject constructor(private val weatherDao: WeatherDao) {
    private val service = RetrofitService.buildService(WeatherService::class.java)

    fun getWeather(city: String, callback: Callback<WeatherBase>) =
        service.getWeather(city).enqueue(callback)

    fun getWeatherFromDb(): Flow<List<WeatherBase>> =
        weatherDao.getLastFiveWeather()

    suspend fun insertWeather(weather: WeatherBase) =
        weatherDao.insertWeather(weather)
}