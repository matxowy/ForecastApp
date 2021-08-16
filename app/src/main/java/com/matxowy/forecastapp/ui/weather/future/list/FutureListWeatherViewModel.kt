package com.matxowy.forecastapp.ui.weather.future.list

import androidx.lifecycle.ViewModel
import com.matxowy.forecastapp.data.provider.UnitProvider
import com.matxowy.forecastapp.data.repository.ForecastRepository
import com.matxowy.forecastapp.internal.lazyDeferred
import com.matxowy.forecastapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}