package com.example.roma.patientapp.presentation.edit_profile.upload_image;

import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.presentation.base.BaseView;

public interface UploadImageContract {

    interface View extends BaseView
    {
        void loadData(SignInResponse response);

        void loadSpinner(RegionResponse response);
    }

    interface Presenter {
        void getSignInResponse();

        void getAllRegionResponse();
    }
}
