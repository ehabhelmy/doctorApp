package com.example.roma.patientapp.data.model.regions;

import java.util.List;

/**
 * Created by Romisaa on 6/18/2018.
 */

public class Government {
    private String id;
    private String name;
    private List<Region> regions = null;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Region> getRegions() {
        return regions;
    }

    public void setRegions(List<Region> regions) {
        this.regions = regions;
    }
}
