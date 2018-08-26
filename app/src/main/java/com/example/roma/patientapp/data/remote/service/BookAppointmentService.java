package com.example.roma.patientapp.data.remote.service;

import com.example.roma.patientapp.data.model.appointment_booked.AppointmentBookedResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by Romisaa on 6/27/2018.
 */
public interface BookAppointmentService {
    @FormUrlEncoded
    @POST("sendRequest")
    Observable<AppointmentBookedResponse> bookAppointment(@Field("token") String token,
                                                           @Field("doctorCode") String doctorCode,
                                                           @Field("serviceId") String serviceId,
                                                           @Field("appointmentId") String appointmentId);
}
