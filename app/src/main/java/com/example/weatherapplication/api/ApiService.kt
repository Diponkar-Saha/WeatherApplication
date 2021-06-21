package com.example.weatherapplication.api

import com.example.weatherapplication.model.Weather
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {
    @GET("weather/Cumilla")
    suspend fun getWeather(): Response<Weather>
}