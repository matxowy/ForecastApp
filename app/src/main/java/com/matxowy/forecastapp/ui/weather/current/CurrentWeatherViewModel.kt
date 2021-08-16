package com.matxowy.forecastapp.ui.weather.current

import androidx.lifecycle.ViewModel
import com.matxowy.forecastapp.data.provider.UnitProvider
import com.matxowy.forecastapp.data.repository.ForecastRepository
import com.matxowy.forecastapp.internal.UnitSystem
import com.matxowy.forecastapp.internal.lazyDeferred
import com.matxowy.forecastapp.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }

}