package com.example.roma.patientapp.presentation.home.book_appointment.adapter;

import com.example.roma.patientapp.data.model.BaseModel;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Romisaa on 6/29/2018.
 */
public class AppointmentRequestDetailModel extends BaseModel {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("Requests")
    @Expose
    private List<Request> requests = null;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Request> getRequests() {
        return requests;
    }

    public void setRequests(List<Request> requests) {
        this.requests = requests;
    }
}
