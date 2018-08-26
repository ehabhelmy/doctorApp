package com.example.roma.patientapp.presentation.edit_profile.update_pw;

import com.example.roma.patientapp.data.model.edit_profile.ChangePasswordResponse;
import com.example.roma.patientapp.domain.usecase.ChangePasswordUseCase;
import com.example.roma.patientapp.domain.usecase.base.DefaultObserver;
import com.example.roma.patientapp.presentation.base.BasePresenter;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Romisaa on 6/25/2018.
 */

public class ChangePasswordPresenter extends BasePresenter<ChangePasswordFragment> implements ChangePasswordContract.Presenter {

    private ChangePasswordUseCase changePasswordUseCase;

    @Inject
    public ChangePasswordPresenter(ChangePasswordUseCase changePasswordUseCase) {
        this.changePasswordUseCase = changePasswordUseCase;
    }

    @Override
    public void changePassword(String pw) {
        Map<String, Object> parameters = new HashMap<>();
        parameters.put(Constants.NEW_PW, pw);

        changePasswordUseCase.execute(parameters, new DefaultObserver<ChangePasswordResponse>() {
            @Override
            public void onNext(ChangePasswordResponse changePasswordResponse) {
                super.onNext(changePasswordResponse);
                if(isViewAttached()){
                    if (changePasswordResponse.getId() == 0) {
                        getView().showSuccess();
                    }else {
                        getView().showError(changePasswordResponse.getDescription());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
            }
        });

    }
}
