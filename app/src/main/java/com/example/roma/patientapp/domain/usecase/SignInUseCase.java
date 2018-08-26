package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/13/2018.
 */

public class SignInUseCase extends UseCase<SignInResponse> {

    @Inject
    public SignInUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<SignInResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.signInPatient(parameters);
    }

    public void saveSignInResponse(SignInResponse response) {
        dataRepository.saveSignInResponse(response);
    }
}
