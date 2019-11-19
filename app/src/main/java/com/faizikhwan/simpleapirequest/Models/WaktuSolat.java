package com.faizikhwan.simpleapirequest.Models;

import com.google.gson.annotations.SerializedName;

public class WaktuSolat {

    @SerializedName("zone")
    String zone;
    @SerializedName("start")
    String start;
    @SerializedName("end")
    String end;
    @SerializedName("locations")
    String[] locations;
    @SerializedName("prayer_times")
    PrayerTime prayerTimes;

    public WaktuSolat(String zone, String start, String end, String[] locations, PrayerTime prayerTimes) {
        this.zone = zone;
        this.start = start;
        this.end = end;
        this.locations = locations;
        this.prayerTimes = prayerTimes;
    }

    public String getZone() {
        return zone;
    }

    public String getStart() {
        return start;
    }

    public String getEnd() {
        return end;
    }

    public String[] getLocations() {
        return locations;
    }

    public PrayerTime getPrayerTimes() {
        return prayerTimes;
    }
}
