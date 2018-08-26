package com.example.roma.patientapp.presentation.doctor_details;

import com.example.roma.patientapp.data.model.doctor_details.DoctorDetailsResponse;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.domain.usecase.DoctorDetailsUseCase;
import com.example.roma.patientapp.domain.usecase.base.DefaultObserver;
import com.example.roma.patientapp.presentation.base.BasePresenter;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsAdapter;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class DoctorDetailsPresenter extends BasePresenter<DoctorDetailsActivity> implements DoctorDetailsContract.Presenter {

    private DoctorDetailsUseCase doctorDetailsUseCase;
    private Doctor searchedDoctor;

    @Inject
    public DoctorDetailsPresenter(DoctorDetailsUseCase doctorDetailsUseCase) {
        this.doctorDetailsUseCase = doctorDetailsUseCase;
    }

    @Override
    public void getDoctorDetails(Doctor doctor) {
        searchedDoctor = doctor;
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.DOCTOR_CODE, searchedDoctor.getMedicalCode());

        final SpecialitiesResponse specialities = doctorDetailsUseCase.getAllSpecialitiesFromLocal();

        doctorDetailsUseCase.execute(params, new DefaultObserver<DoctorDetailsResponse>() {
            @Override
            public void onNext(DoctorDetailsResponse doctorDetailsResponse) {
                super.onNext(doctorDetailsResponse);
                getView().loadData(new DoctorDetailsAdapter().getDoctorDetailModel(searchedDoctor, doctorDetailsResponse, specialities));
            }
        });
    }

}
