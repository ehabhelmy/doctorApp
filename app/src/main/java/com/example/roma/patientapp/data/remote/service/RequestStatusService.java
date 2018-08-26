package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.data.model.login.SignInResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/29/2018.
 */
public interface RequestStatusService {
    @FormUrlEncoded
    @POST("getRequestStatus")
    Observable<RequestStatusResponse> getRequestStatus(@Field("token") String token, @Field("requestId") String requestId);
}
