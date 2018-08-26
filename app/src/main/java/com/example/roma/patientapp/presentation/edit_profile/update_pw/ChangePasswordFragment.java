package com.example.roma.patientapp.presentation.edit_profile.update_pw;


import android.support.v7.app.AlertDialog;
import android.widget.EditText;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.presentation.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class ChangePasswordFragment extends BaseFragment implements ChangePasswordContract.View {

    @BindView(R.id.new_pw_et)
    EditText newPasswordET;

    @BindView(R.id.confirm_pw_et)
    EditText confirmPasswordET;

    @Inject
    ChangePasswordPresenter changePasswordPresenter;

    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = changePasswordPresenter;
        changePasswordPresenter.setView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_change_password;
    }

    @OnClick(R.id.change_pw_tv)
    public void changePassword() {
        if (validatePW(newPasswordET.getText().toString(), confirmPasswordET.getText().toString())) {
            changePasswordPresenter.changePassword(newPasswordET.getText().toString());
        }
    }

    private Boolean validatePW(String newPw, String confirmPw) {
        return newPw.equals(confirmPw) ? true : false;
    }

    @Override
    public void showSuccess() {
        new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.success))
                .setMessage("Password Changed Successfully")
                .show();
    }
}
