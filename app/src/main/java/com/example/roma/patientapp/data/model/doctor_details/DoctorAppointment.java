package com.example.roma.patientapp.data.model.doctor_details;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class DoctorAppointment implements Parcelable {
    private String id;
    private String day;
    private String fromHour;
    private String toHour;
    private String isFull;

    public DoctorAppointment(String day, String fromHour, String toHour) {
        this.day = day;
        this.fromHour = fromHour;
        this.toHour = toHour;
    }

    protected DoctorAppointment(Parcel in) {
        id = in.readString();
        day = in.readString();
        fromHour = in.readString();
        toHour = in.readString();
        isFull = in.readString();
    }

    public static final Creator<DoctorAppointment> CREATOR = new Creator<DoctorAppointment>() {
        @Override
        public DoctorAppointment createFromParcel(Parcel in) {
            return new DoctorAppointment(in);
        }

        @Override
        public DoctorAppointment[] newArray(int size) {
            return new DoctorAppointment[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getFromHour() {
        return fromHour;
    }

    public void setFromHour(String fromHour) {
        this.fromHour = fromHour;
    }

    public String getToHour() {
        return toHour;
    }

    public void setToHour(String toHour) {
        this.toHour = toHour;
    }

    public String getIsFull() {
        return isFull;
    }

    public void setIsFull(String isFull) {
        this.isFull = isFull;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(day);
        dest.writeString(fromHour);
        dest.writeString(toHour);
        dest.writeString(isFull);
    }
}
