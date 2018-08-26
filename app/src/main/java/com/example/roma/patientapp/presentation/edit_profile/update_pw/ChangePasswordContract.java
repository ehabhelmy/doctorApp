package com.example.roma.patientapp.presentation.edit_profile.update_pw;

import com.example.roma.patientapp.presentation.base.BaseView;

/**
 * Created by Romisaa on 6/25/2018.
 */

public interface ChangePasswordContract {

    interface View extends BaseView {

        void showSuccess();
    }

    interface Presenter {
        void changePassword(String pw);
    }
}
