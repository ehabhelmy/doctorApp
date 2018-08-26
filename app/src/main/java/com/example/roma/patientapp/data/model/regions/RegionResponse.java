package com.example.roma.patientapp.data.model.regions;

import java.util.List;

/**
 * Created by Romisaa on 6/18/2018.
 */

public class RegionResponse {
    private Integer id;
    private String description;
    private List<Government> governments = null;

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

    public List<Government> getGovernments() {
        return governments;
    }

    public void setGovernments(List<Government> governments) {
        this.governments = governments;
    }
}
