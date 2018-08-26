package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.appointment_booked.AppointmentBookedResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/27/2018.
 */
public class AppointmentBookedUseCase extends UseCase<AppointmentBookedResponse> {

    @Inject
    public AppointmentBookedUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<AppointmentBookedResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.bookAppointment(parameters);
    }

    public void saveAppointmentRequestDetail(AppointmentRequestDetailModel model) {
        dataRepository.saveAppointmentRequestDetail(model);
    }
}
