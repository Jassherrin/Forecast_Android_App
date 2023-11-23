package com.example.practical12;


public class General {
    private String forecast;
    private RelativeHumidity relative_humidity;
    private Temperature temperature;
    private Wind wind;

    public String getForecast() {
        return forecast;
    }

    public void setForecast(String forecast) {
        this.forecast = forecast;
    }

    public RelativeHumidity getRelative_humidity() {
        return relative_humidity;
    }

    public void setRelative_humidity(RelativeHumidity relative_humidity) {
        this.relative_humidity = relative_humidity;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public void setTemperature(Temperature temperature) {
        this.temperature = temperature;
    }

    public Wind getWind() {
        return wind;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }
}
