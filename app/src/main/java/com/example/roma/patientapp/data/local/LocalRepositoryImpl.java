package com.example.roma.patientapp.data.local;

import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.utils.constants.PrefrenceConstants;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class LocalRepositoryImpl implements LocalRepository {

    PreferencesManager preferencesManager;
    DatabaseManager databaseManager;

    @Inject
    public LocalRepositoryImpl(PreferencesManager preferencesManager, DatabaseManager databaseManager) {
        this.preferencesManager = preferencesManager;
        this.databaseManager = databaseManager;
    }


    @Override
    public void saveSpecialitiesResponse(SpecialitiesResponse specialitiesResponse) {
        preferencesManager.saveObject(PrefrenceConstants.SPECIALITIES_RESPONSE, specialitiesResponse);
    }

    @Override
    public void saveRegionResponse(RegionResponse regionResponse) {
        preferencesManager.saveObject(PrefrenceConstants.REGION_RESPONSE, regionResponse);
    }

    @Override
    public SpecialitiesResponse getAllSpecialities() {
        return preferencesManager.getObject(PrefrenceConstants.SPECIALITIES_RESPONSE, SpecialitiesResponse.class);
    }

    @Override
    public RegionResponse getALlRegions() {
        return preferencesManager.getObject(PrefrenceConstants.REGION_RESPONSE, null);
    }

    @Override
    public void saveSignInResponse(SignInResponse response) {
        preferencesManager.saveObject(PrefrenceConstants.SIGNIN_RESPONSE, response);
    }

    @Override
    public String getToken() {
        SignInResponse response = preferencesManager.getObject(PrefrenceConstants.SIGNIN_RESPONSE, SignInResponse.class);
        return response != null ? response.getToken() : null;
    }

    @Override
    public SignInResponse getSignInResponse() {
        SignInResponse response = preferencesManager.getObject(PrefrenceConstants.SIGNIN_RESPONSE, SignInResponse.class);
        return response != null ? response : null;
    }

    @Override
    public RegionResponse getRegionResponse() {
        RegionResponse response = preferencesManager.getObject(PrefrenceConstants.SPECIALITIES_RESPONSE, RegionResponse.class);
        return response != null ? response : null;
    }

    @Override
    public void saveAppointmentRequestDetail(AppointmentRequestDetailModel model) {
        List<AppointmentRequestDetailModel> requests = preferencesManager.getList(PrefrenceConstants.REQUESTS, AppointmentRequestDetailModel.class);
        if (requests == null) {
            requests = new ArrayList<>();
        }
        requests.add(model);
        preferencesManager.setList(PrefrenceConstants.REQUESTS, requests);
    }

    @Override
    public List<AppointmentRequestDetailModel> getAppointmentsRequestsDetails() {
        List<AppointmentRequestDetailModel> requests = preferencesManager.getList(PrefrenceConstants.REQUESTS, new TypeToken<List<AppointmentRequestDetailModel>>() {
        }.getType());
        return requests != null ? requests : null;
    }
}
