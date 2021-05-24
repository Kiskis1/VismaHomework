package com.example.vismahomework.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.vismahomework.models.WeatherBase
import com.example.vismahomework.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    fun getWeatherFromApi(city: String) {
        weatherRepository.getWeather(city, object : Callback<WeatherBase> {
            override fun onResponse(call: Call<WeatherBase>, response: Response<WeatherBase>) {
                if (response.isSuccessful) {
                    viewModelScope.launch {
                        insertPosts(response.body()!!)
                    }
                }
            }

            override fun onFailure(call: Call<WeatherBase>, t: Throwable) {
            }
        })
    }

    private suspend fun insertPosts(body: WeatherBase) {
        weatherRepository.insertWeather(body)
    }
}