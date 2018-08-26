package com.example.roma.patientapp.data.local;

import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;

import java.util.List;

public interface LocalRepository {
    void saveSpecialitiesResponse(SpecialitiesResponse specialitiesResponse);

    void saveRegionResponse(RegionResponse regionResponse);

    SpecialitiesResponse getAllSpecialities();

    RegionResponse getALlRegions();

    void saveSignInResponse(SignInResponse response);

    String getToken();

    SignInResponse getSignInResponse();

    RegionResponse getRegionResponse();

    void saveAppointmentRequestDetail(AppointmentRequestDetailModel requestId);

    List<AppointmentRequestDetailModel> getAppointmentsRequestsDetails();
}
