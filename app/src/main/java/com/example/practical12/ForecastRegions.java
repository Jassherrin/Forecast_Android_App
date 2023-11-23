package com.example.practical12;
import com.google.gson.annotations.SerializedName;

public class ForecastRegions {
    @SerializedName("west")
    private String west;

    @SerializedName("east")
    private String east;

    @SerializedName("central")
    private String central;

    @SerializedName("south")
    private String south;

    @SerializedName("north")
    private String north;

    public String getWest() {
        return west;
    }

    public void setWest(String west) {
        this.west = west;
    }

    public String getEast() {
        return east;
    }

    public void setEast(String east) {
        this.east = east;
    }

    public String getCentral() {
        return central;
    }

    public void setCentral(String central) {
        this.central = central;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getNorth() {
        return north;
    }

    public void setNorth(String north) {
        this.north = north;
    }
}
