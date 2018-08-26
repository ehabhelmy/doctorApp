package com.example.roma.patientapp.data.model.doctor_details;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class Service implements Parcelable {
    private String id;
    private String type;
    private String speciality;
    private String price;
    private String discountPercentage;

    protected Service(Parcel in) {
        id = in.readString();
        type = in.readString();
        speciality = in.readString();
        price = in.readString();
        discountPercentage = in.readString();
    }

    public static final Creator<Service> CREATOR = new Creator<Service>() {
        @Override
        public Service createFromParcel(Parcel in) {
            return new Service(in);
        }

        @Override
        public Service[] newArray(int size) {
            return new Service[size];
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

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscountPercentage() {
        return discountPercentage;
    }

    public void setDiscountPercentage(String discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(type);
        dest.writeString(speciality);
        dest.writeString(price);
        dest.writeString(discountPercentage);
    }
}
