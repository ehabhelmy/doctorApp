package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/18/2018.
 */

public class AllSpecialitiesUseCase extends UseCase<SpecialitiesResponse> {

    @Inject
    public AllSpecialitiesUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<SpecialitiesResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.getAllSpecialities();
    }

    public void saveSpecialitiesResponse(SpecialitiesResponse specialitiesResponse) {
        dataRepository.saveSpecialitiesResponse(specialitiesResponse);
    }
}
