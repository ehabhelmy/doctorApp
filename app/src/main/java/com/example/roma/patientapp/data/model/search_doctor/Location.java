package com.example.roma.patientapp.data.model.search_doctor;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class Location implements Parcelable{

    private String longitude;
    private String latitude;

    protected Location(Parcel in) {
        longitude = in.readString();
        latitude = in.readString();
    }

    public static final Creator<Location> CREATOR = new Creator<Location>() {
        @Override
        public Location createFromParcel(Parcel in) {
            return new Location(in);
        }

        @Override
        public Location[] newArray(int size) {
            return new Location[size];
        }
    };

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(longitude);
        dest.writeString(latitude);
    }
}
