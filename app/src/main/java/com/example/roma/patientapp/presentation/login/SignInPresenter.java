package com.example.roma.patientapp.presentation.login;

import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.domain.usecase.SignInUseCase;
import com.example.roma.patientapp.domain.usecase.base.DefaultObserver;
import com.example.roma.patientapp.presentation.base.BasePresenter;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Romisaa on 6/13/2018.
 */

public class SignInPresenter extends BasePresenter<SignInActivity> implements SignInContract.Presenter {

    private SignInUseCase signInUseCase;

    @Inject
    public SignInPresenter(SignInUseCase signInUseCase) {
        this.signInUseCase = signInUseCase;
    }

    @Override
    public void signIn(String code, String pw) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Constants.CODE, code);
        parameters.put(Constants.PW, pw);

        DefaultObserver<SignInResponse> observer = new DefaultObserver<SignInResponse>() {

            @Override
            public void onNext(SignInResponse response) {
                super.onNext(response);
                if (isViewAttached()) {
                    if (response.getId() == Constants.REQUEST_SUCCESS) {
                        signInUseCase.saveSignInResponse(response);
                        navigationManager.navigateToHomeActivity();
                    } else {
                        getView().showError(response.getDescription());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (isViewAttached()) {
                    getView().showError("Server Error");
                }
            }


        };

        signInUseCase.execute(parameters, observer);
    }

}
