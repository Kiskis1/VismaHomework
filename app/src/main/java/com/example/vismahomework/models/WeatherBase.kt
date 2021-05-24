package com.example.vismahomework.models

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.example.vismahomework.DataConverter
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "Weather")
@TypeConverters(DataConverter::class)
data class WeatherBase(
    @ColumnInfo(name = "weather")
    val weather: List<Weather>,
    @Embedded val main: Main,
    val dt: Long,
    val name: String,
) {
    @PrimaryKey(autoGenerate = true)
    var id1: Long = 0

    @Ignore
    var iconURL: String = "http://openweathermap.org/img/wn/${weather[0].icon}@2x.png"
}

@Parcelize
data class Main(
    val temp: Double,
    val temp_min: Double,
    val temp_max: Double,
) : Parcelable

data class Weather(
    val id: Long,
    val description: String,
    val icon: String,
)
