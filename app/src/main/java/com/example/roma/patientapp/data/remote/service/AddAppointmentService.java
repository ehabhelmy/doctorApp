package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;

import java.util.ArrayList;
import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface AddAppointmentService {

    @FormUrlEncoded
    @POST("updateAppointments")
    Observable<RequestStatusResponse> getRequestStatus(@Field("token") String token, @FieldMap Map<String, String> appointments);

}
