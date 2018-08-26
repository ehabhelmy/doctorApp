package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.login.SignInResponse;

import io.reactivex.Observable;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/13/2018.
 */

public interface SignInService {

    @FormUrlEncoded
    @POST("login")
    Observable<SignInResponse> signInPatient(@Field("code") String code,@Field("hashedPassword") String hashedPassword);
}
