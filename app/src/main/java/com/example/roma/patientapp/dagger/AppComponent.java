package com.example.roma.patientapp.dagger;

import com.example.roma.patientapp.presentation.doctor_details.DoctorDetailsActivity;
import com.example.roma.patientapp.presentation.edit_profile.update_info.EditProfileFragment;
import com.example.roma.patientapp.presentation.edit_profile.update_pw.ChangePasswordFragment;
import com.example.roma.patientapp.presentation.home.appointments.AppointmentsFragment;
import com.example.roma.patientapp.presentation.home.book_appointment.AppointmentBookedActivity;
import com.example.roma.patientapp.presentation.home.HomeActivity;
import com.example.roma.patientapp.presentation.login.SignInActivity;
import com.example.roma.patientapp.presentation.splash.SplashActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {

    void inject(SignInActivity signInActivity);

    void inject(HomeActivity homeActivity);

    void inject(DoctorDetailsActivity doctorDetailsActivity);

    void inject(ChangePasswordFragment changePasswordFragment);

    void inject(AppointmentBookedActivity appointmentBookedActivity);

    void inject(EditProfileFragment editProfileFragment);

    void inject(AppointmentsFragment appointmentsFragment);

    void inject(SplashActivity splashActivity);
}
