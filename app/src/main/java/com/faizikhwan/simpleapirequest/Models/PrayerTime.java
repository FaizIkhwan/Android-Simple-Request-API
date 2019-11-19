package com.faizikhwan.simpleapirequest.Models;

import com.google.gson.annotations.SerializedName;

public class PrayerTime {
    @SerializedName("date")
    String date;
    @SerializedName("datestamp")
    int datestamp;
    @SerializedName("imsak")
    String imsak;
    @SerializedName("subuh")
    String subuh;
    @SerializedName("syuruk")
    String syuruk;
    @SerializedName("zohor")
    String zohor;
    @SerializedName("asar")
    String asar;
    @SerializedName("maghrib")
    String maghrib;
    @SerializedName("isyak")
    String isyak;

    public PrayerTime(String date, int datestamp, String imsak, String subuh, String syuruk, String zohor, String asar, String maghrib, String isyak) {
        this.date = date;
        this.datestamp = datestamp;
        this.imsak = imsak;
        this.subuh = subuh;
        this.syuruk = syuruk;
        this.zohor = zohor;
        this.asar = asar;
        this.maghrib = maghrib;
        this.isyak = isyak;
    }

    public String getDate() {
        return date;
    }

    public int getDatestamp() {
        return datestamp;
    }

    public String getImsak() {
        return imsak;
    }

    public String getSubuh() {
        return subuh;
    }

    public String getSyuruk() {
        return syuruk;
    }

    public String getZohor() {
        return zohor;
    }

    public String getAsar() {
        return asar;
    }

    public String getMaghrib() {
        return maghrib;
    }

    public String getIsyak() {
        return isyak;
    }
}
