package com.example.roma.patientapp.presentation.splash;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.presentation.base.BaseActivity;
import com.example.roma.patientapp.presentation.home.HomeActivity;
import com.example.roma.patientapp.presentation.login.SignInActivity;

import javax.inject.Inject;

public class SplashActivity extends BaseActivity implements SplashContract.View {

    @Inject
    SplashPresenter splashPresenter;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_splash;
    }

    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = splashPresenter;
        splashPresenter.setView(this);
    }

    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        splashPresenter.onSplashEnd();
    }

    @Override
    public void openLogin() {
        startActivity(new Intent(this, SignInActivity.class));
        finish();
    }

    @Override
    public void openHome() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }
}
