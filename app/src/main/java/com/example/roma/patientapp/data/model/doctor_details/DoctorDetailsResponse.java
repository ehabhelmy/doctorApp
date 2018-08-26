package com.example.roma.patientapp.data.model.doctor_details;

import java.util.List;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class DoctorDetailsResponse {
    private Integer id;
    private String description;
    private List<DoctorAppointment> doctorAppointments = null;
    private List<Service> services = null;

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
}
