package com.matxowy.forecastapp.data.network

import androidx.lifecycle.LiveData
import com.matxowy.forecastapp.data.network.response.CurrentWeatherResponse
import com.matxowy.forecastapp.data.network.response.FutureWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String
    )

    suspend fun fetchFutureWeather(
        location: String
    )
}