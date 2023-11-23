package com.example.practical12;
import retrofit2.Call;
import retrofit2.http.GET;

import retrofit2.Call;
import retrofit2.http.GET;

public interface WeatherService {
    @GET("environment/24-hour-weather-forecast")
    Call<WeatherResponse> getWeatherForecast();
}
