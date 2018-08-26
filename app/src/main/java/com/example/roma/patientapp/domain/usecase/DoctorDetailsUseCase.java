package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.doctor_details.DoctorDetailsResponse;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class DoctorDetailsUseCase extends UseCase<DoctorDetailsResponse> {

    @Inject
    public DoctorDetailsUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<DoctorDetailsResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.getDoctorDetails(parameters);
    }

    public SpecialitiesResponse getAllSpecialitiesFromLocal() {
        return dataRepository.getAllSpecialitiesFromLocale();
    }

}
