package com.example.roma.patientapp.data.model.specialities;

import java.util.List;

/**
 * Created by Romisaa on 6/18/2018.
 */

public class SpecialitiesResponse {
    private Integer id;
    private String description;
    private List<Speciality> specialities = null;

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

    public List<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(List<Speciality> specialities) {
        this.specialities = specialities;
    }
}
