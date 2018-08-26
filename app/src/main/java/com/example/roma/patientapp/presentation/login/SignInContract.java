package com.example.roma.patientapp.presentation.login;

import com.example.roma.patientapp.presentation.base.BaseView;
import com.example.roma.patientapp.presentation.base.ErrorView;

/**
 * Created by Romisaa on 6/13/2018.
 */

public class SignInContract {

    interface View extends BaseView,ErrorView{

    }

    interface Presenter {
        void signIn(String code, String pw);
    }
}

