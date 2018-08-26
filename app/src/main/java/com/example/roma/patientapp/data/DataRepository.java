package com.example.roma.patientapp.data;


import com.example.roma.patientapp.data.model.appointment_booked.AppointmentBookedResponse;
import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.data.model.doctor_details.DoctorDetailsResponse;
import com.example.roma.patientapp.data.model.edit_profile.ChangePasswordResponse;
import com.example.roma.patientapp.data.model.edit_profile.UpdateInfoModel;
import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.data.model.search_doctor.SearchDoctorResponse;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.data.model.updateimage.UpdateImageResponse;
import com.example.roma.patientapp.data.model.uploadimage.UploadImageResponse;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;


/**
 * Created by Romisaa on 4/20/2018.
 */

public interface DataRepository {

    Observable<SignInResponse> signInPatient(Map<String, Object> parameters);

    Observable<SearchDoctorResponse> SearchDoctor(Map<String, Object> parameters);

    Observable<DoctorDetailsResponse> getDoctorDetails(Map<String, Object> parameters);

    Observable<SpecialitiesResponse> getAllSpecialities();

    Observable<RegionResponse> getALlRegions();

    void saveSpecialitiesResponse(SpecialitiesResponse specialitiesResponse);

    void saveRegionResponse(RegionResponse regionResponse);

    SpecialitiesResponse getAllSpecialitiesFromLocale();

    RegionResponse getALlRegionsFromLocal();

    void saveSignInResponse(SignInResponse response);

    Observable<ChangePasswordResponse> changePassword(Map<String, Object> parameters);

    Observable<AppointmentBookedResponse> bookAppointment(Map<String, Object> parameters);

    String getToken();

    SignInResponse getSignInResponse();

    RegionResponse getRegionResponse();

    void saveAppointmentRequestDetail(AppointmentRequestDetailModel requestId);

    Observable<AppointmentRequestDetailModel> getAppointmentsRequestsDetails();

    Observable<RequestStatusResponse> getRequestStatus(Map<String, Object> parameters);

    Observable<RequestStatusResponse> approveRequest(Map<String, Object> parameters);

    Observable<RequestStatusResponse> rejectRequest(Map<String, Object> parameters);

    Observable<RequestStatusResponse> finishRequest(Map<String, Object> parameters);

    Observable<RequestStatusResponse> addAppointment(Map<String, Object> parameters);

    Observable<UpdateImageResponse> updateImage(Map<String, Object> parameters);

    Observable<UploadImageResponse> uploadImage(Map<String, Object> parameters);

    Observable<Response<ResponseBody>> downloadImage(Map<String, Object> parameters);

    Observable<UpdateInfoModel> updateInfo(Map<String,Object> parameters);

}
