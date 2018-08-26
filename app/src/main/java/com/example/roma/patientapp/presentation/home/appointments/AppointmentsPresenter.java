package com.example.roma.patientapp.presentation.home.appointments;

import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;
import com.example.roma.patientapp.domain.usecase.AddAppointmentUseCase;
import com.example.roma.patientapp.domain.usecase.RequestStatusUseCase;
import com.example.roma.patientapp.domain.usecase.base.DefaultObserver;
import com.example.roma.patientapp.presentation.base.BasePresenter;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Romisaa on 6/29/2018.
 */
public class AppointmentsPresenter extends BasePresenter<AppointmentsContract.View> implements AppointmentsContract.Presenter {

    private AddAppointmentUseCase addAppointmentUseCase;

    @Inject
    public AppointmentsPresenter(AddAppointmentUseCase addAppointmentUseCase) {
        this.addAppointmentUseCase = addAppointmentUseCase;
    }

    @Override
    public void addAppointments(List<DoctorAppointment> doctorAppointments) {
        Map<String,Object> params = new HashMap<>();
        params.put(Constants.Appointment,doctorAppointments);
        addAppointmentUseCase.execute(params,new DefaultObserver<RequestStatusResponse>(){
            @Override
            public void onNext(RequestStatusResponse requestStatusResponse) {
                super.onNext(requestStatusResponse);
                if (requestStatusResponse.getId() == 0){
                    if (isViewAttached()){
                        getView().showSuccess();
                    }
                }else {
                    if (isViewAttached()){
                        getView().showError(requestStatusResponse.getDescription());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (isViewAttached()) {
                    getView().showError("Server Error");
                }
            }
        });
    }
}
