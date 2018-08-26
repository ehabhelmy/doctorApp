package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;

import java.util.List;
import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/29/2018.
 */
public class RequestStatusUseCase extends UseCase<RequestStatusResponse> {

    @Inject
    public RequestStatusUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<RequestStatusResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.getRequestStatus(parameters);
    }

}
