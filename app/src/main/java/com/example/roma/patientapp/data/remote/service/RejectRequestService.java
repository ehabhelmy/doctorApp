package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface RejectRequestService {

    @FormUrlEncoded
    @POST("rejectRequest")
    Observable<RequestStatusResponse> getRequestStatus(@Field("token") String token, @Field("requestId") String requestId);

}
