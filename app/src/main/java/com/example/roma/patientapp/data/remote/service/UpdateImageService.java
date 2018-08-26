package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.updateimage.UpdateImageResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface UpdateImageService {

    @FormUrlEncoded
    @POST("updateImage")
    Observable<UpdateImageResponse> updateImage(@Field("token") String token, @Field("location") String locationURL);

}
