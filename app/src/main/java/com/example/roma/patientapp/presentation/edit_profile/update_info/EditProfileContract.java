package com.example.roma.patientapp.presentation.edit_profile.update_info;

import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.presentation.base.BaseView;

/**
 * Created by Romisaa on 6/15/2018.
 */

public interface EditProfileContract {

    interface View extends BaseView {
        void loadData(SignInResponse response);
    }

    interface Presenter {
        void getSignInResponse();
        void updateInfo(String firstName,String lastName,String mobile,String email);
    }
}
