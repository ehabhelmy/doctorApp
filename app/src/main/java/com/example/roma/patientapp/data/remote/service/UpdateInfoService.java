package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.edit_profile.UpdateInfoModel;
import com.example.roma.patientapp.data.model.login.SignInResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/29/2018.
 */
public interface UpdateInfoService {
    @FormUrlEncoded
    @POST("updateInfo")
    Observable<UpdateInfoModel> updateInfo(
            @Field("token") String token,
            @Field("firstName") String firstName,
            @Field("lastName") String lastName,
            @Field("email") String email,
            @Field("mobileNumber") String mobileNumber);
}
