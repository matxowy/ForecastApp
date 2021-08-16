package com.matxowy.forecastapp.data.provider

import com.matxowy.forecastapp.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}