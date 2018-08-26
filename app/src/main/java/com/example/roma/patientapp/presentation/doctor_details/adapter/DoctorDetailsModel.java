package com.example.roma.patientapp.presentation.doctor_details.adapter;

import android.os.Parcel;
import android.os.Parcelable;

import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;
import com.example.roma.patientapp.data.model.doctor_details.Service;
import com.example.roma.patientapp.data.model.search_doctor.Location;
import com.example.roma.patientapp.data.model.search_doctor.ServiceProvider;

import java.util.List;

/**
 * Created by Romisaa on 6/18/2018.
 */

public class DoctorDetailsModel implements Parcelable {

    private String medicalCode;
    private String rate;
    private String lastName;
    private String speciality;
    private String imageLocation;
    private String address;
    private String mobileNumber;
    private Location location;
    private String price;
    private String discount;
    private String date;
    private String time;
    private String firstAvailableDate;
    private String firstAvailableTime;
    private ServiceProvider serviceProvider;
    private List<DoctorAppointment> doctorAppointments = null;
    private List<Service> services = null;


    public DoctorDetailsModel() {
    }

    protected DoctorDetailsModel(Parcel in) {
        medicalCode = in.readString();
        rate = in.readString();
        lastName = in.readString();
        speciality = in.readString();
        imageLocation = in.readString();
        address = in.readString();
        mobileNumber = in.readString();
        location = in.readParcelable(Location.class.getClassLoader());
        price = in.readString();
        discount = in.readString();
        date = in.readString();
        time = in.readString();
        firstAvailableDate = in.readString();
        firstAvailableTime = in.readString();
        serviceProvider = in.readParcelable(ServiceProvider.class.getClassLoader());
        doctorAppointments = in.createTypedArrayList(DoctorAppointment.CREATOR);
        services = in.createTypedArrayList(Service.CREATOR);
    }

    public static final Creator<DoctorDetailsModel> CREATOR = new Creator<DoctorDetailsModel>() {
        @Override
        public DoctorDetailsModel createFromParcel(Parcel in) {
            return new DoctorDetailsModel(in);
        }

        @Override
        public DoctorDetailsModel[] newArray(int size) {
            return new DoctorDetailsModel[size];
        }
    };

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

    public List<DoctorAppointment> getDoctorAppointments() {
        return doctorAppointments;
    }

    public void setDoctorAppointments(List<DoctorAppointment> doctorAppointments) {
        this.doctorAppointments = doctorAppointments;
    }

    public List<Service> getServices() {
        return services;
    }

    public void setServices(List<Service> services) {
        this.services = services;
    }

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFirstAvailableDate() {
        return firstAvailableDate;
    }

    public void setFirstAvailableDate(String firstAvailableDate) {
        this.firstAvailableDate = firstAvailableDate;
    }

    public String getFirstAvailableTime() {
        return firstAvailableTime;
    }

    public void setFirstAvailableTime(String firstAvailableTime) {
        this.firstAvailableTime = firstAvailableTime;
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
        dest.writeString(address);
        dest.writeString(mobileNumber);
        dest.writeParcelable(location, flags);
        dest.writeString(price);
        dest.writeString(discount);
        dest.writeString(date);
        dest.writeString(time);
        dest.writeString(firstAvailableDate);
        dest.writeString(firstAvailableTime);
        dest.writeParcelable(serviceProvider, flags);
        dest.writeTypedList(doctorAppointments);
        dest.writeTypedList(services);
    }


}
