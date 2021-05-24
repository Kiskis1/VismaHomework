package com.example.vismahomework.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.vismahomework.db.dao.WeatherDao
import com.example.vismahomework.models.WeatherBase

@Database(entities = [WeatherBase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun weatherDao(): WeatherDao
}