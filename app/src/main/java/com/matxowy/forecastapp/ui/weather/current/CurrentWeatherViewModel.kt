package com.matxowy.forecastapp.ui.weather.current

import androidx.lifecycle.ViewModel
import com.matxowy.forecastapp.data.repository.ForecastRepository
import com.matxowy.forecastapp.internal.UnitSystem
import com.matxowy.forecastapp.internal.lazyDeferred

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository
) : ViewModel() {
    private val unitSystem = UnitSystem.METRIC

    val isMetric: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(isMetric)
    }
    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}