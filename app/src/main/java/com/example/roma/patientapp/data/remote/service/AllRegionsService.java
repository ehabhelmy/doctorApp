package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.regions.RegionResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/18/2018.
 */

public interface AllRegionsService {
    @FormUrlEncoded
    @POST("getAllRegions")
    Observable<RegionResponse> getAllRegions(@Field("token") String token);
}
