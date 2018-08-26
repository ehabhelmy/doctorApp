package com.example.roma.patientapp.data.remote;

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

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Romisaa on 4/21/2018.
 */

public interface RemoteRepository {

    Observable<SignInResponse> signInPatient(Map<String, Object> parameters);

    Observable<SearchDoctorResponse> searchDoctor(Map<String, Object> parameters);

    Observable<DoctorDetailsResponse> getDoctorDetails(Map<String, Object> parameters);

    Observable<SpecialitiesResponse> getAllSpecialities(String token);

    Observable<RegionResponse> getALlRegions(String token);

    Observable<ChangePasswordResponse> changePassword(Map<String, Object> parameters);

    Observable<AppointmentBookedResponse> bookAppointment(Map<String, Object> parameters);

    Observable<AppointmentRequestDetailModel> getAppointmentsRequestsDetails(String token);

    Observable<RequestStatusResponse> getRequestStatus(Map<String, Object> parameters);

    Observable<RequestStatusResponse> approveRequest(Map<String, Object> parameters);

    Observable<RequestStatusResponse> rejectRequest(Map<String, Object> parameters);

    Observable<RequestStatusResponse> finishRequest(Map<String, Object> parameters);

    Observable<RequestStatusResponse> addAppointment(Map<String, Object> parameters);

    Observable<UpdateImageResponse> updateImage(Map<String, Object> parameters);

    Observable<UploadImageResponse> uploadImage(Map<String, Object> parameters);

    Observable<Response<ResponseBody>> downloadImage(Map<String, Object> parameters);

    Observable<UpdateInfoModel> updateInfo(Map<String, Object> parameters);
}
