package com.example.roma.patientapp.presentation.home.book_appointment.adapter;

import com.example.roma.patientapp.data.model.BaseModel;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Request extends BaseModel {
    @SerializedName("id")
    @Expose
    private String clientId;
    @SerializedName("patient_name")
    @Expose
    private String patientName;
    @SerializedName("doctor_appointment_id")
    @Expose
    private String doctorAppointmentId;
    @SerializedName("status")
    @Expose
    private String status;

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorAppointmentId() {
        return doctorAppointmentId;
    }

    public void setDoctorAppointmentId(String doctorAppointmentId) {
        this.doctorAppointmentId = doctorAppointmentId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
