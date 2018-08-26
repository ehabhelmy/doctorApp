package com.example.roma.patientapp.data;


import com.example.roma.patientapp.data.local.LocalRepository;
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
import com.example.roma.patientapp.data.remote.RemoteRepository;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.List;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.Response;


public class DataRepositoryImpl implements DataRepository {

    private RemoteRepository remoteRepository;
    private LocalRepository localRepository;

    public DataRepositoryImpl(RemoteRepository remoteRepository, LocalRepository localRepository) {
        this.remoteRepository = remoteRepository;
        this.localRepository = localRepository;
    }

    @Override
    public Observable<SignInResponse> signInPatient(Map<String, Object> parameters) {
        return remoteRepository.signInPatient(parameters);
    }

    @Override
    public Observable<SearchDoctorResponse> SearchDoctor(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.searchDoctor(parameters);
    }

    @Override
    public Observable<DoctorDetailsResponse> getDoctorDetails(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.getDoctorDetails(parameters);
    }

    @Override
    public Observable<SpecialitiesResponse> getAllSpecialities() {
        return remoteRepository.getAllSpecialities(getToken());
    }

    @Override
    public Observable<RegionResponse> getALlRegions() {
        return remoteRepository.getALlRegions(getToken());
    }

    @Override
    public void saveSpecialitiesResponse(SpecialitiesResponse specialitiesResponse) {
        localRepository.saveSpecialitiesResponse(specialitiesResponse);
    }

    @Override
    public void saveRegionResponse(RegionResponse regionResponse) {
        localRepository.saveRegionResponse(regionResponse);
    }

    @Override
    public SpecialitiesResponse getAllSpecialitiesFromLocale() {
        return localRepository.getAllSpecialities();
    }

    @Override
    public RegionResponse getALlRegionsFromLocal() {
        return localRepository.getALlRegions();
    }

    @Override
    public void saveSignInResponse(SignInResponse response) {
        localRepository.saveSignInResponse(response);
    }

    @Override
    public Observable<ChangePasswordResponse> changePassword(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.changePassword(parameters);
    }

    @Override
    public Observable<AppointmentBookedResponse> bookAppointment(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.bookAppointment(parameters);
    }

    @Override
    public String getToken() {
        return localRepository.getToken();
    }

    @Override
    public SignInResponse getSignInResponse() {
        return localRepository.getSignInResponse();
    }

    @Override
    public RegionResponse getRegionResponse() {
        return localRepository.getRegionResponse();
    }

    @Override
    public void saveAppointmentRequestDetail(AppointmentRequestDetailModel requestId) {
        localRepository.saveAppointmentRequestDetail(requestId);
    }

    @Override
    public Observable<AppointmentRequestDetailModel> getAppointmentsRequestsDetails() {
        return remoteRepository.getAppointmentsRequestsDetails(getToken());
    }

    @Override
    public Observable<RequestStatusResponse> getRequestStatus(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.getRequestStatus(parameters);
    }

    @Override
    public Observable<RequestStatusResponse> approveRequest(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.approveRequest(parameters);
    }

    @Override
    public Observable<RequestStatusResponse> rejectRequest(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.rejectRequest(parameters);
    }

    @Override
    public Observable<RequestStatusResponse> finishRequest(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.finishRequest(parameters);
    }

    @Override
    public Observable<RequestStatusResponse> addAppointment(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.addAppointment(parameters);
    }

    @Override
    public Observable<UpdateImageResponse> updateImage(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.updateImage(parameters);
    }

    @Override
    public Observable<UploadImageResponse> uploadImage(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.uploadImage(parameters);
    }

    @Override
    public Observable<Response<ResponseBody>> downloadImage(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.downloadImage(parameters);
    }

    @Override
    public Observable<UpdateInfoModel> updateInfo(Map<String, Object> parameters) {
        parameters.put(Constants.TOKEN, getToken());
        return remoteRepository.updateInfo(parameters);
    }
}
