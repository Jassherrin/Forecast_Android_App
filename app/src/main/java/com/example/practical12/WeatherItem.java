package com.example.practical12;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherItem {
    @SerializedName("periods")
    private List<WeatherForecast> periods;

    public List<WeatherForecast> getPeriods() {
        return periods;
    }

    public void setPeriods(List<WeatherForecast> periods) {
        this.periods = periods;
    }
}
