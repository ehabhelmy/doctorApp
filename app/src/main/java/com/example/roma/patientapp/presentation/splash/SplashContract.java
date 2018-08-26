package com.example.roma.patientapp.presentation.splash;

import com.example.roma.patientapp.presentation.base.BaseView;

/**
 * Created by Romisaa on 6/15/2018.
 */

public interface SplashContract {
    interface View extends BaseView{
        void openLogin();
        void openHome();
    }

    interface Presenter {
        void onSplashEnd();
    }
}
