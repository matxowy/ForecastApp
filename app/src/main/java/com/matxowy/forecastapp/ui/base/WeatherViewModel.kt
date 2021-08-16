package com.matxowy.forecastapp.ui.base

import androidx.lifecycle.ViewModel
import com.matxowy.forecastapp.data.provider.UnitProvider
import com.matxowy.forecastapp.data.repository.ForecastRepository
import com.matxowy.forecastapp.internal.UnitSystem
import com.matxowy.forecastapp.internal.lazyDeferred

abstract class WeatherViewModel(
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : ViewModel() {

    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean
        get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }
}