package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class AddAppointmentUseCase extends UseCase<RequestStatusResponse> {

    @Inject
    public AddAppointmentUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<RequestStatusResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.addAppointment(parameters);
    }
}
