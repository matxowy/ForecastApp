package com.matxowy.forecastapp.ui.weather.future.detail

import androidx.lifecycle.ViewModel
import com.matxowy.forecastapp.data.provider.UnitProvider
import com.matxowy.forecastapp.data.repository.ForecastRepository
import com.matxowy.forecastapp.internal.lazyDeferred
import com.matxowy.forecastapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
        private val detailDate: LocalDate,
        private val forecastRepository: ForecastRepository,
        unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}