package com.example.roma.patientapp.data.remote;

import com.example.roma.patientapp.data.model.appointment_booked.AppointmentBookedResponse;
import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;
import com.example.roma.patientapp.data.model.doctor_details.DoctorDetailsResponse;
import com.example.roma.patientapp.data.model.edit_profile.ChangePasswordResponse;
import com.example.roma.patientapp.data.model.edit_profile.UpdateInfoModel;
import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.data.model.search_doctor.SearchDoctorRequest;
import com.example.roma.patientapp.data.model.search_doctor.SearchDoctorResponse;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.data.model.updateimage.UpdateImageResponse;
import com.example.roma.patientapp.data.model.uploadimage.UploadImageResponse;
import com.example.roma.patientapp.data.remote.service.AddAppointmentService;
import com.example.roma.patientapp.data.remote.service.AllRegionsService;
import com.example.roma.patientapp.data.remote.service.AllRequestService;
import com.example.roma.patientapp.data.remote.service.AllSpecialitiesService;
import com.example.roma.patientapp.data.remote.service.ApproveRequestService;
import com.example.roma.patientapp.data.remote.service.BookAppointmentService;
import com.example.roma.patientapp.data.remote.service.ChangePasswordService;
import com.example.roma.patientapp.data.remote.service.DoctorDetailsService;
import com.example.roma.patientapp.data.remote.service.DownloadImageService;
import com.example.roma.patientapp.data.remote.service.FinishRequestService;
import com.example.roma.patientapp.data.remote.service.RejectRequestService;
import com.example.roma.patientapp.data.remote.service.RequestStatusService;
import com.example.roma.patientapp.data.remote.service.SearchDoctorService;
import com.example.roma.patientapp.data.remote.service.SignInService;
import com.example.roma.patientapp.data.remote.service.UpdateImageService;
import com.example.roma.patientapp.data.remote.service.UpdateInfoService;
import com.example.roma.patientapp.data.remote.service.UploadImageService;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.utils.constants.Constants;
import com.google.gson.Gson;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Response;

/**
 * Created by Romisaa on 4/21/2018.
 */

public class RemoteRepositoryImpl implements RemoteRepository {

    private ServiceGenerator serviceGenerator;

    public RemoteRepositoryImpl(ServiceGenerator serviceGenerator) {
        this.serviceGenerator = serviceGenerator;
    }

    @Override
    public Observable<SignInResponse> signInPatient(Map<String, Object> parameters) {
        SignInService service = this.serviceGenerator.createService(SignInService.class);
        return service.signInPatient((String) parameters.get(Constants.CODE), (String) parameters.get(Constants.PW));
    }

    @Override
    public Observable<SearchDoctorResponse> searchDoctor(Map<String, Object> parameters) {
        final SearchDoctorRequest request = new SearchDoctorRequest();
        SearchDoctorService service = this.serviceGenerator.createService(SearchDoctorService.class);
        return service.searchDoctor((String) parameters.get(Constants.TOKEN), (String) parameters.get(Constants.DOCTOR_NAME), "0", "10");
    }

    @Override
    public Observable<DoctorDetailsResponse> getDoctorDetails(Map<String, Object> parameters) {
        DoctorDetailsService service = this.serviceGenerator.createService(DoctorDetailsService.class);
        return service.getDoctorDetails((String) parameters.get(Constants.TOKEN), (String) parameters.get("doctorCode"));
    }

    @Override
    public Observable<SpecialitiesResponse> getAllSpecialities(String token) {
        AllSpecialitiesService service = this.serviceGenerator.createService(AllSpecialitiesService.class);
        return service.getAllSpecialities(token);
    }

    @Override
    public Observable<RegionResponse> getALlRegions(String token) {
        AllRegionsService service = this.serviceGenerator.createService(AllRegionsService.class);
        return service.getAllRegions(token);
    }

    @Override
    public Observable<ChangePasswordResponse> changePassword(Map<String, Object> parameters) {
        ChangePasswordService service = this.serviceGenerator.createService(ChangePasswordService.class);
        return service.changePassword((String) parameters.get(Constants.TOKEN), (String) parameters.get(Constants.NEW_PW));
    }

    @Override
    public Observable<AppointmentBookedResponse> bookAppointment(Map<String, Object> parameters) {
        BookAppointmentService service = this.serviceGenerator.createService(BookAppointmentService.class);
        return service.bookAppointment((String) parameters.get(Constants.TOKEN), (String) parameters.get(Constants.DOCTOR_CODE),
                (String) parameters.get(Constants.SERVICE_ID), (String) parameters.get(Constants.APPOINTMENT_ID));
    }

    @Override
    public Observable<AppointmentRequestDetailModel> getAppointmentsRequestsDetails(String token) {
        AllRequestService service = this.serviceGenerator.createService(AllRequestService.class);
        return service.getAllRequests(token);
    }

    @Override
    public Observable<RequestStatusResponse> getRequestStatus(Map<String, Object> parameters) {
        RequestStatusService service = this.serviceGenerator.createService(RequestStatusService.class);
        return service.getRequestStatus((String) parameters.get(Constants.TOKEN), (String) parameters.get(Constants.REQUEST_ID));
    }

    @Override
    public Observable<RequestStatusResponse> approveRequest(Map<String, Object> parameters) {
        ApproveRequestService service = this.serviceGenerator.createService(ApproveRequestService.class);
        return service.getRequestStatus((String) parameters.get(Constants.TOKEN), (String) parameters.get(Constants.REQUEST_ID));
    }

    @Override
    public Observable<RequestStatusResponse> rejectRequest(Map<String, Object> parameters) {
        RejectRequestService service = this.serviceGenerator.createService(RejectRequestService.class);
        return service.getRequestStatus((String) parameters.get(Constants.TOKEN), (String) parameters.get(Constants.REQUEST_ID));
    }

    @Override
    public Observable<RequestStatusResponse> finishRequest(Map<String, Object> parameters) {
        FinishRequestService service = this.serviceGenerator.createService(FinishRequestService.class);
        return service.getRequestStatus((String) parameters.get(Constants.TOKEN), (String) parameters.get(Constants.REQUEST_ID));
    }

    @Override
    public Observable<RequestStatusResponse> addAppointment(Map<String, Object> parameters) {
        AddAppointmentService service = this.serviceGenerator.createService(AddAppointmentService.class);
        ArrayList<DoctorAppointment> doctorAppointments = (ArrayList<DoctorAppointment>) parameters.get(Constants.Appointment);
        Gson gson = new Gson();
        String value = gson.toJson(doctorAppointments);
        Map<String,String> map = new HashMap<>();
        map.put("Appointments",value);
        return service.getRequestStatus((String) parameters.get(Constants.TOKEN), map);
    }

    @Override
    public Observable<UpdateImageResponse> updateImage(Map<String, Object> parameters) {
        UpdateImageService service = this.serviceGenerator.createService(UpdateImageService.class);
        return service.updateImage((String) parameters.get(Constants.TOKEN),(String) parameters.get(Constants.LOCATION));
    }

    @Override
    public Observable<UploadImageResponse> uploadImage(Map<String, Object> parameters) {
        UploadImageService service = this.serviceGenerator.createService(UploadImageService.class);
        MultipartBody.Part requestImagePart = null;
        File image = (File) parameters.get(Constants.FILE);
        if (image != null) {
            RequestBody requestImage = RequestBody.create(MediaType.parse("image/*"), image);
            requestImagePart =
                    MultipartBody.Part.createFormData("file", image.getName(), requestImage);
        }
        return service.uploadImage((String) parameters.get(Constants.TOKEN),requestImagePart);

    }

    @Override
    public Observable<Response<ResponseBody>> downloadImage(Map<String, Object> parameters) {
        DownloadImageService service = this.serviceGenerator.createService(DownloadImageService.class);
        return service.downloadImage((String) parameters.get(Constants.TOKEN),(String) parameters.get(Constants.LOCATION));
    }

    @Override
    public Observable<UpdateInfoModel> updateInfo(Map<String, Object> parameters) {
        UpdateInfoService service = this.serviceGenerator.createService(UpdateInfoService.class);
        return service.updateInfo((String) parameters.get(Constants.TOKEN),(String) parameters.get(Constants.F_NAME),(String) parameters.get(Constants.L_NAME),(String) parameters.get(Constants.M_NUMBER),(String) parameters.get(Constants.EMAIL));
    }
}
