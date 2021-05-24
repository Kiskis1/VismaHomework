package com.example.vismahomework

import androidx.room.TypeConverter
import com.example.vismahomework.models.Weather
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type
import java.util.Collections

class DataConverter {

    @TypeConverter
    fun stringToWeatherList(data: String?): List<Weather?>? {
        if (data == null) {
            return Collections.emptyList()
        }
        val listType: Type = object :
            TypeToken<List<Weather?>?>() {}.type
        return Gson().fromJson<List<Weather?>>(data, listType)
    }

    @TypeConverter
    fun listWeatherToString(someObjects: List<Weather?>?): String? {
        return Gson().toJson(someObjects)
    }
}