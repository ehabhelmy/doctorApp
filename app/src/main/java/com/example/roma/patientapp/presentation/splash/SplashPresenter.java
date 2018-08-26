package com.example.roma.patientapp.presentation.splash;

import android.os.Handler;

import com.example.roma.patientapp.domain.usecase.TokenUseCase;
import com.example.roma.patientapp.presentation.base.BasePresenter;

import javax.inject.Inject;


/**
 * Created by Romisaa on 6/15/2018.
 */

public class SplashPresenter extends BasePresenter<SplashContract.View> implements SplashContract.Presenter {

    private TokenUseCase tokenUseCase;

    @Inject
    public SplashPresenter(TokenUseCase tokenUseCase) {
        this.tokenUseCase = tokenUseCase;
    }

    @Override
    public void onSplashEnd() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (tokenUseCase.getToken() == null){
                    if (isViewAttached()) {
                        getView().openLogin();
                    }
                }else {
                    if (isViewAttached()) {
                        getView().openHome();
                    }
                }
            }
        },4000);
    }
}
