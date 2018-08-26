package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.edit_profile.ChangePasswordResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/25/2018.
 */

public class ChangePasswordUseCase extends UseCase<ChangePasswordResponse> {

    @Inject
    public ChangePasswordUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<ChangePasswordResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.changePassword(parameters);
    }
}
