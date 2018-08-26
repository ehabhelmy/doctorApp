package com.example.roma.patientapp.presentation.home;

import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.Request;

import java.util.ArrayList;

/**
 * Created by Romisaa on 6/15/2018.
 */

public interface HomeContract {

    interface View {
        void loadDate(ArrayList<Request> allRequests, ArrayList<Request> pendingRequests, ArrayList<Request> approvedRequests, ArrayList<Request> cancelledRequests);
        void approveSuccess();
        void rejectSuccess();
        void finishSuccess();
    }

    interface Presenter {

        void navigateToEditProfileFragment();

        void navigateToAppointmentsFragment();

        void navigateToSettingsFragment();

        void navigateToLogOutFragment();

        void navigateToAboutFragment();

        void getAppointmentsRequests();

        void onRequestApproved(String id);

        void onRequestRejected(String id);

        void onRequestFinished(String id);

    }
}
