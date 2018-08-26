package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.search_doctor.SearchDoctorResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/17/2018.
 */

public class SearchDoctorUseCase extends UseCase<SearchDoctorResponse> {

    @Inject
    public SearchDoctorUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<SearchDoctorResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.SearchDoctor(parameters);
    }
}
