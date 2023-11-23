package com.example.practical12;

import com.google.gson.annotations.SerializedName;

import java.util.List;
import java.util.Map;

public class WeatherPeriod{
    @SerializedName("time")
    private Time time;

    @SerializedName("regions")
    private Regions regions;

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Regions getRegions() {
        return regions;
    }

    public void setRegions(Regions regions) {
        this.regions = regions;
    }
}
