package com.matxowy.forecastapp.data.network

import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import com.matxowy.forecastapp.data.network.response.CurrentWeatherResponse
import com.matxowy.forecastapp.data.network.response.FutureWeatherResponse
import kotlinx.coroutines.Deferred
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

const val API_KEY = "ba920f0778a042df827104235212807"

//http://api.weatherapi.com/v1/current.json?key=ba920f0778a042df827104235212807&q=London&aqi=no

//http://api.weatherapi.com/v1/forecast.json?key=ba920f0778a042df827104235212807&q=London&days=1&aqi=no&alerts=no

interface WeatherapiApiService {

    @GET("current.json")
    fun getCurrentWeatherAsync(
        @Query("q") location: String,
        @Query("aqi") airQuality: String = "no"
    ) : Deferred<CurrentWeatherResponse> // zwracany typ w Deferred bo na odpowiedź możemy chwilę czekać więc nie może nam zablokować wątku głównego

    @GET("forecast.json")
    fun getFutureWeatherAsync(
            @Query("q") location: String,
            @Query("days") days: Int,
            @Query("aqi") airQuality: String = "no",
            @Query("alerts") alerts: String = "no"
    ) : Deferred<FutureWeatherResponse>

    companion object {
        operator fun invoke(
            connectivityInterceptor: ConnectivityInterceptor
        ): WeatherapiApiService { // nadpisujemy operator invoke by móc zwracać się wygodnie do WeatherstackApiService()
            val requestInterceptor = Interceptor { chain ->

                val url = chain.request()
                    .url()
                    .newBuilder()
                    .addQueryParameter("key", API_KEY)
                    .build()

                val request = chain.request()
                    .newBuilder()
                    .url(url)
                    .build()

                return@Interceptor chain.proceed(request)
            }

            val okHttpClient = OkHttpClient.Builder()
                .addInterceptor(requestInterceptor)
                .addInterceptor(connectivityInterceptor)
                .build()

            return Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl("http://api.weatherapi.com/v1/")
                .addCallAdapterFactory(CoroutineCallAdapterFactory())
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(WeatherapiApiService::class.java)
        }
    }
}