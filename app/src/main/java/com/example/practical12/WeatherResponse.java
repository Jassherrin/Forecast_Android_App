package com.example.practical12;
import com.google.gson.annotations.SerializedName;
import java.util.List;

public class WeatherResponse {
    @SerializedName("items")
    private List<WeatherItem> items;

    public List<WeatherItem> getItems() {
        return items;
    }

    public void setItems(List<WeatherItem> items) {
        this.items = items;
    }
}
