package com.example.roma.patientapp.data.model.search_doctor;

import java.util.List;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class SearchDoctorResponse {

    private Integer id;
    private String description;
    private List<Doctor> doctors = null;

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

    public List<Doctor> getDoctors() {
        return doctors;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }
}
