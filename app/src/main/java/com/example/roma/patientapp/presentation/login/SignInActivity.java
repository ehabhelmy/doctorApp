package com.example.roma.patientapp.presentation.login;

import android.widget.Button;
import android.widget.EditText;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.presentation.base.BaseActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by Romisaa on 6/13/2018.
 */

public class SignInActivity extends BaseActivity implements SignInContract.View {

    @BindView(R.id.id_et)
    EditText id;

    @BindView(R.id.pw_et)
    EditText pw;

    @BindView(R.id.sign_in_btn)
    Button signin_btn;

    @Inject
    SignInPresenter signInPresenter;

    @OnClick(R.id.sign_in_btn)
    public void login() {
        if (!(id.getText().toString().isEmpty()) && !(pw.getText().toString().isEmpty())) {
            signInPresenter.signIn(id.getText().toString(), pw.getText().toString());
        }

    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = signInPresenter;
        signInPresenter.setView(this);
    }

    @Override
    public void showError(String msg) {

    }

}
