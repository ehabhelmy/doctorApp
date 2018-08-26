package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.doctor_details.DoctorDetailsResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/17/2018.
 */

public interface DoctorDetailsService {
    @FormUrlEncoded
    @POST("getDoctorDetails")
    Observable<DoctorDetailsResponse> getDoctorDetails(@Field("token") String token,
                                                       @Field("doctorCode") String doctorName);
}
