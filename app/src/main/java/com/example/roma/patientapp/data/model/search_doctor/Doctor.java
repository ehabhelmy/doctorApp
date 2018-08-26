package com.example.roma.patientapp.data.model.search_doctor;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class Doctor implements Parcelable{

    private String medicalCode;
    private String rate;
    private String lastName;
    private String speciality;
    private String imageLocation;
    private String mobileNumber;
    private ServiceProvider serviceProvider;

    protected Doctor(Parcel in) {
        medicalCode = in.readString();
        rate = in.readString();
        lastName = in.readString();
        speciality = in.readString();
        imageLocation = in.readString();
        mobileNumber = in.readString();
        serviceProvider = in.readParcelable(ServiceProvider.class.getClassLoader());
    }

    public static final Creator<Doctor> CREATOR = new Creator<Doctor>() {
        @Override
        public Doctor createFromParcel(Parcel in) {
            return new Doctor(in);
        }

        @Override
        public Doctor[] newArray(int size) {
            return new Doctor[size];
        }
    };

    public String getMedicalCode() {
        return medicalCode;
    }

    public void setMedicalCode(String medicalCode) {
        this.medicalCode = medicalCode;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getImageLocation() {
        return imageLocation;
    }

    public void setImageLocation(String imageLocation) {
        this.imageLocation = imageLocation;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public ServiceProvider getServiceProvider() {
        return serviceProvider;
    }

    public void setServiceProvider(ServiceProvider serviceProvider) {
        this.serviceProvider = serviceProvider;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(medicalCode);
        dest.writeString(rate);
        dest.writeString(lastName);
        dest.writeString(speciality);
        dest.writeString(imageLocation);
        dest.writeString(mobileNumber);
        dest.writeParcelable(serviceProvider, flags);
    }
}
