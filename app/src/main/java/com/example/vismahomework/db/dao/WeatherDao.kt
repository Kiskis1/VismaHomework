package com.example.vismahomework.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.vismahomework.models.WeatherBase
import kotlinx.coroutines.flow.Flow

@Dao
interface WeatherDao {
    @Query("SELECT * FROM Weather ORDER BY id1 desc LIMIT 5")
    fun getLastFiveWeather(): Flow<List<WeatherBase>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWeather(weather: WeatherBase)
}