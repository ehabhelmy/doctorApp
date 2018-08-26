package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.uploadimage.UploadImageResponse;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface DownloadImageService {

    @FormUrlEncoded
    @POST("downloadImage")
    Observable<Response<ResponseBody>> downloadImage(@Field("token") String token, @Field("fileURL") String url);

}
