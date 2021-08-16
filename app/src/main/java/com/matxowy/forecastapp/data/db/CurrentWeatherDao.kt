package com.matxowy.forecastapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.matxowy.forecastapp.data.db.entity.CURRENT_WEATHER_ID
import com.matxowy.forecastapp.data.db.entity.CurrentWeatherEntry
import com.matxowy.forecastapp.data.db.unitlocalized.current.ImperialCurrentWeatherEntry
import com.matxowy.forecastapp.data.db.unitlocalized.current.MetricCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE) // zawsze będziemy mieli konflikt bo mamy stałe id = 0 więc ustawiamy żeby się podmieniało podczas konfliktu
    fun upsert(weatherEntry: CurrentWeatherEntry) // upsert bo update jak jest coś w bazie, a jak nie to insert

    @Query("SELECT * FROM current_weather WHERE id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("SELECT * FROM current_weather WHERE id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}