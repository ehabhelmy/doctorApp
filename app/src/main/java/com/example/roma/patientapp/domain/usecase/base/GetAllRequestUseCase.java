package com.example.roma.patientapp.domain.usecase.base;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class GetAllRequestUseCase extends UseCase<AppointmentRequestDetailModel> {

    @Inject
    public GetAllRequestUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<AppointmentRequestDetailModel> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.getAppointmentsRequestsDetails();
    }
}
