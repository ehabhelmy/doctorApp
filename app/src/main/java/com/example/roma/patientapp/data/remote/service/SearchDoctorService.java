package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.search_doctor.SearchDoctorResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/17/2018.
 */

public interface SearchDoctorService {
    @FormUrlEncoded
    @POST("searchDoctor")
    Observable<SearchDoctorResponse> searchDoctor(@Field("token") String token,
                                                  @Field("doctorName") String doctorName,
                                                  @Field("start") String start,
                                                  @Field("limit") String limit);
}