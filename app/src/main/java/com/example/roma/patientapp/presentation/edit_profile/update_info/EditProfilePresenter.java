package com.example.roma.patientapp.presentation.edit_profile.update_info;

import com.example.roma.patientapp.data.model.edit_profile.UpdateInfoModel;
import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.domain.usecase.EditProfileUseCase;
import com.example.roma.patientapp.domain.usecase.base.DefaultObserver;
import com.example.roma.patientapp.presentation.base.BasePresenter;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.HashMap;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Romisaa on 6/15/2018.
 */

public class EditProfilePresenter extends BasePresenter<EditProfileContract.View> implements EditProfileContract.Presenter {

    private EditProfileUseCase editProfileUseCase;

    @Inject
    public EditProfilePresenter(EditProfileUseCase editProfileUseCase) {
        this.editProfileUseCase = editProfileUseCase;
    }

    @Override
    public void getSignInResponse() {
        SignInResponse response = editProfileUseCase.getSignInResponse();
        if (response != null) {
            getView().loadData(response);
        }
    }

    @Override
    public void updateInfo(String firstName, String lastName, String mobile, String email) {
        Map<String,Object> params = new HashMap<>();
        params.put(Constants.F_NAME,firstName);
        params.put(Constants.L_NAME,lastName);
        params.put(Constants.M_NUMBER,mobile);
        params.put(Constants.EMAIL,email);
        editProfileUseCase.execute(params,new DefaultObserver<UpdateInfoModel>(){
            @Override
            public void onNext(UpdateInfoModel updateInfoModel) {
                super.onNext(updateInfoModel);
                if (isViewAttached()){
                    if (updateInfoModel.getId() == 0) {
                        navigationManager.navigateToUploadImageFragment();
                    }else {
                        getView().showError(updateInfoModel.getDescription());
                    }
                }
            }

            @Override
            public void onError(Throwable e) {
                super.onError(e);
                if (isViewAttached()) {
                    getView().showError("Server error");
                }
            }
        });
    }

}
