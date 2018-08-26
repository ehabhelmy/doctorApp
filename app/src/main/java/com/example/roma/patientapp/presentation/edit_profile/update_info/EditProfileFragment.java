package com.example.roma.patientapp.presentation.edit_profile.update_info;


import android.support.v7.widget.AppCompatEditText;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.presentation.base.BaseFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class EditProfileFragment extends BaseFragment implements EditProfileContract.View {

    @BindView(R.id.id_et)
    AppCompatEditText idEditText;

    @BindView(R.id.first_name_et)
    AppCompatEditText nameEditText;

    @BindView(R.id.last_name_et)
    AppCompatEditText lastNameEditText;

    @BindView(R.id.phone_number_et)
    AppCompatEditText mobileEditText;

    @BindView(R.id.email_et)
    AppCompatEditText emailEditText;

    @Inject
    EditProfilePresenter editProfilePresenter;

    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = editProfilePresenter;
        editProfilePresenter.setView(this);
        editProfilePresenter.getSignInResponse();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_edit_profile;
    }

    @OnClick(R.id.next_tv)
    public void navigateToUploadImageFragment() {
        editProfilePresenter.updateInfo(nameEditText.getText().toString().trim(),lastNameEditText.getText().toString().trim(),mobileEditText.getText().toString().trim(),emailEditText.getText().toString().trim());
    }

    @OnClick(R.id.change_pw_tv)
    public void navigateToChangePwFragment() {
        navigationManager.navigateToChangePwFragment();
    }

    @Override
    public void loadData(SignInResponse response) {
        idEditText.setText(String.valueOf(response.getId()));
        nameEditText.setText(String.format("%s %s", response.getUserInfo().getFirstName(), response.getUserInfo().getLastName()));
    }

}
