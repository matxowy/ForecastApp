package com.matxowy.forecastapp.data.network.response


import com.google.gson.annotations.SerializedName
import com.matxowy.forecastapp.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
        @SerializedName("forecast")
        val futureWeatherEntries: ForecastDaysContainer,
        val location: WeatherLocation
)