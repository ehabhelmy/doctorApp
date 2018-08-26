package com.example.roma.patientapp.presentation.home.book_appointment;

import com.example.roma.patientapp.data.model.appointment_booked.AppointmentBookedResponse;
import com.example.roma.patientapp.domain.usecase.AppointmentBookedUseCase;
import com.example.roma.patientapp.domain.usecase.base.DefaultObserver;
import com.example.roma.patientapp.presentation.base.BasePresenter;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsModel;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

import static com.example.roma.patientapp.utils.constants.Constants.REQUEST_SUCCESS;

/**
 * Created by Romisaa on 6/27/2018.
 */
public class AppointmentBookedPresenter extends BasePresenter<AppointmentBookedActivity> implements AppointmentBookedContract.Presenter {

    private AppointmentBookedUseCase appointmentBookedUseCase;

    @Inject
    public AppointmentBookedPresenter(AppointmentBookedUseCase appointmentBookedUseCase) {
        this.appointmentBookedUseCase = appointmentBookedUseCase;
    }


}
