package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.edit_profile.UpdateInfoModel;
import com.example.roma.patientapp.data.model.login.SignInResponse;
import com.example.roma.patientapp.data.model.login.UserInfo;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/29/2018.
 */
public class EditProfileUseCase extends UseCase<UpdateInfoModel> {

    @Inject
    public EditProfileUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<UpdateInfoModel> buildUseCaseObservable(Map<String, Object> parameters) {
        String fname = (String) parameters.get(Constants.F_NAME);
        String lName = (String) parameters.get(Constants.L_NAME);
        String mobile = (String) parameters.get(Constants.M_NUMBER);
        String email = (String) parameters.get(Constants.EMAIL);
        SignInResponse signInResponse = new SignInResponse();
        UserInfo userInfo = new UserInfo();
        userInfo.setFirstName(fname);
        userInfo.setLastName(lName);
        userInfo.setEmail(email);
        userInfo.setMobileNumber(mobile);
        signInResponse.setUserInfo(userInfo);
        dataRepository.saveSignInResponse(signInResponse);
        return dataRepository.updateInfo(parameters);
    }

    public SignInResponse getSignInResponse() {
        return dataRepository.getSignInResponse();
    }
}
