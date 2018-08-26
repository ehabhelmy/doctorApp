package com.example.roma.patientapp.presentation.home.appointments;

import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;
import com.example.roma.patientapp.presentation.base.BaseView;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Romisaa on 6/29/2018.
 */
public interface AppointmentsContract {
    interface View extends BaseView {

        void showSuccess();
    }

    interface Presenter {
        void addAppointments(List<DoctorAppointment> doctorAppointments);
    }
}
