package com.example.roma.patientapp.data.model.appointments;

/**
 * Created by Romisaa on 6/29/2018.
 */
public class RequestStatusResponse {

    private Integer id;
    private String description;
    private String requestStatus;

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

    public String getRequestStatus() {
        return requestStatus;
    }

    public void setRequestStatus(String requestStatus) {
        this.requestStatus = requestStatus;
    }
}
