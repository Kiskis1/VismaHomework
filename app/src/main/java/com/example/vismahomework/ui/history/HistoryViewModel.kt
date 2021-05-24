package com.example.vismahomework.ui.history

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.example.vismahomework.models.WeatherBase
import com.example.vismahomework.repository.WeatherRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HistoryViewModel @Inject constructor(
    private val weatherRepository: WeatherRepository,
) : ViewModel() {

    fun getWeather(): LiveData<List<WeatherBase>> {
        return weatherRepository.getWeatherFromDb().asLiveData()
    }
}