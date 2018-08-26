package com.example.roma.patientapp.data.model.appointment_booked;

/**
 * Created by Romisaa on 6/27/2018.
 */
public class AppointmentBookedResponse {

    private Integer id;
    private String description;
    private String requestId;

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

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

}
