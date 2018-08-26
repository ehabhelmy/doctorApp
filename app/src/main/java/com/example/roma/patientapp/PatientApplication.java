package com.example.roma.patientapp;

import android.app.Application;
import android.content.Context;

import com.example.roma.patientapp.dagger.AppComponent;
import com.example.roma.patientapp.dagger.AppModule;
import com.example.roma.patientapp.dagger.DaggerAppComponent;

/**
 * Created by Romisaa on 6/15/2018.
 */

public class PatientApplication extends Application {

    private static Context context;
    private static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
    }

    public static Context getContext() {
        return context;
    }

    public static AppComponent getComponenet() {
        if (appComponent == null) {
            appComponent = DaggerAppComponent.builder().appModule(new AppModule((Application) PatientApplication.getContext())).build();
        }
        return appComponent;
    }


}
