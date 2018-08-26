package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AllRequestService {
    @FormUrlEncoded
    @POST("getAllRequests")
    Observable<AppointmentRequestDetailModel> getAllRequests(@Field("token") String token);

}
