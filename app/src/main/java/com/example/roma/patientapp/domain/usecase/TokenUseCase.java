package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.BaseModel;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

public class TokenUseCase extends UseCase<BaseModel>{

    @Inject
    public TokenUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<BaseModel> buildUseCaseObservable(Map<String, Object> parameters) {
        return null;
    }

    public String getToken(){
        return dataRepository.getToken();
    }
}
