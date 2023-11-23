package com.example.practical12;
import com.google.gson.annotations.SerializedName;

public class WeatherForecast {
    @SerializedName("time")
    private Time time;

    @SerializedName("regions")
    private ForecastRegions regions;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public ForecastRegions getRegions() {
        return regions;
    }

    public void setRegions(ForecastRegions regions) {
        this.regions = regions;
    }
}
