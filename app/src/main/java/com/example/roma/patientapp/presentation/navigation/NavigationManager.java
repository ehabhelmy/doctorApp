package com.example.roma.patientapp.presentation.navigation;

import android.content.Intent;

import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.presentation.doctor_details.DoctorDetailsActivity;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsModel;
import com.example.roma.patientapp.presentation.edit_profile.update_info.EditProfileFragment;
import com.example.roma.patientapp.presentation.edit_profile.update_pw.ChangePasswordFragment;
import com.example.roma.patientapp.presentation.edit_profile.upload_image.UploadImageFragment;
import com.example.roma.patientapp.presentation.home.HomeActivity;
import com.example.roma.patientapp.presentation.home.appointments.AppointmentsFragment;
import com.example.roma.patientapp.presentation.home.book_appointment.AppointmentBookedActivity;
import com.example.roma.patientapp.utils.constants.Constants;

/**
 * Created by Romisaa on 6/14/2018.
 */

public class NavigationManager extends BaseNavigationManager {

    @Override
    public void navigateToChangePwFragment() {
        replaceFragment(R.id.home_container, new ChangePasswordFragment(), true);
    }

    @Override
    public void navigateToUploadImageFragment() {
        replaceFragment(R.id.home_container, new UploadImageFragment(), false);
    }

    @Override
    public void navigateToHomeActivity() {
        Intent intent = new Intent(getCurrentActivity(), HomeActivity.class);
        getCurrentActivity().startActivity(intent);
    }

    @Override
    public void navigateToEditProfileFragment() {
        replaceFragment(R.id.home_container, new EditProfileFragment(), true);
    }

    @Override
    public void navigateToAppointmentsFragment() {
        replaceFragment(R.id.home_container, new AppointmentsFragment(), true);
    }

    @Override
    public void navigateToSettingsFragment() {

    }

    @Override
    public void navigateToLogOutFragment() {

    }

    @Override
    public void navigateToAboutFragment() {

    }

    @Override
    public void navigateDoctorDetailsActivity(Doctor doctor) {
        Intent intent = new Intent(getCurrentActivity(), DoctorDetailsActivity.class);
        intent.putExtra(Constants.DOCTOR, doctor);
        getCurrentActivity().startActivity(intent);
    }

    @Override
    public void navigateToBookAppointmentActivity(DoctorDetailsModel doctor) {
        Intent intent = new Intent(getCurrentActivity(), AppointmentBookedActivity.class);
        intent.putExtra(Constants.DOCTOR, doctor);
        getCurrentActivity().startActivity(intent);
    }
}
