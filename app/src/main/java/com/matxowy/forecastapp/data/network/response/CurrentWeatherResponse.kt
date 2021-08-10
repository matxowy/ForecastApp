package com.matxowy.forecastapp.data.network.response

import com.google.gson.annotations.SerializedName
import com.matxowy.forecastapp.data.db.entity.CurrentWeatherEntry
import com.matxowy.forecastapp.data.db.entity.WeatherLocation

data class CurrentWeatherResponse(
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry,
    @SerializedName("location")
    val weatherLocation: WeatherLocation
)