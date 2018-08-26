package com.example.roma.patientapp.presentation.navigation;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.presentation.base.BaseActivity;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsModel;
import com.example.roma.patientapp.utils.StringUtils;

import java.lang.ref.WeakReference;

/**
 * Created by Romisaa on 6/13/2018.
 */

public abstract class BaseNavigationManager {

    private static BaseNavigationManager navigationManager;

    protected FragmentManager fragmentManager;

    protected WeakReference<BaseActivity> currentActivity;


    public static BaseNavigationManager getInstance() {
        if (navigationManager == null) {
            navigationManager = new NavigationManager();
        }
        return navigationManager;
    }

    public void setFragmentManager(FragmentManager fragmentManager) {
        this.fragmentManager = fragmentManager;
    }

    public BaseActivity getCurrentActivity() {
        return currentActivity.get();
    }

    public void setCurrentActivity(BaseActivity currentActivity) {
        this.currentActivity = new WeakReference<>(currentActivity);
    }

    public void replaceFragment(int containerViewId, Fragment fragment, boolean addToBackStack) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(containerViewId, fragment);
        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commitNowAllowingStateLoss();
    }


    public void addFragment(int containerViewId, Fragment fragment, boolean addToBackStack, String tag) {
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        if (StringUtils.isNull(tag)) {
            transaction.add(containerViewId, fragment);
        } else {
            transaction.add(containerViewId, fragment, tag);
        }

        if (addToBackStack) transaction.addToBackStack(null);
        transaction.commitAllowingStateLoss();
    }

    abstract public void navigateToChangePwFragment();

    public abstract void navigateToUploadImageFragment();

    public abstract void navigateToHomeActivity();

    public abstract void navigateToEditProfileFragment();

    public abstract void navigateToAppointmentsFragment();

    public abstract void navigateToSettingsFragment();

    public abstract void navigateToLogOutFragment();

    public abstract void navigateToAboutFragment();

    public abstract void navigateDoctorDetailsActivity(Doctor doctor);

    public abstract void navigateToBookAppointmentActivity(DoctorDetailsModel doctor);
}
