package com.matxowy.forecastapp.data.network.response


import com.google.gson.annotations.SerializedName
import com.matxowy.forecastapp.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
        @SerializedName("forecastday")
        val entries: List<FutureWeatherEntry>
)