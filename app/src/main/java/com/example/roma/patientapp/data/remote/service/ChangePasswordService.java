package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.edit_profile.ChangePasswordResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/25/2018.
 */

public interface ChangePasswordService {
    @FormUrlEncoded
    @POST("changePassword")
    Observable<ChangePasswordResponse> changePassword(@Field("token") String token, @Field("newHashedPassword") String pw);
}
