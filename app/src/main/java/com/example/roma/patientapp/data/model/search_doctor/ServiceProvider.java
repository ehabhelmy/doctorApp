package com.example.roma.patientapp.data.model.search_doctor;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class ServiceProvider implements Parcelable{

    private String id;
    private String type;
    private String name;
    private String phoneNumber;
    private String mobileNumber;
    private String address;
    private String region;
    private String government;
    private Location location;


    protected ServiceProvider(Parcel in) {
        id = in.readString();
        type = in.readString();
        name = in.readString();
        phoneNumber = in.readString();
        mobileNumber = in.readString();
        address = in.readString();
        region = in.readString();
        government = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
    }

    public static final Creator<ServiceProvider> CREATOR = new Creator<ServiceProvider>() {
        @Override
        public ServiceProvider createFromParcel(Parcel in) {
            return new ServiceProvider(in);
        }

        @Override
        public ServiceProvider[] newArray(int size) {
            return new ServiceProvider[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getGovernment() {
        return government;
    }

    public void setGovernment(String government) {
        this.government = government;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        dest.writeString(name);
        dest.writeString(phoneNumber);
        dest.writeString(mobileNumber);
        dest.writeString(address);
        dest.writeString(region);
        dest.writeString(government);
        dest.writeParcelable(location, flags);
    }
}
