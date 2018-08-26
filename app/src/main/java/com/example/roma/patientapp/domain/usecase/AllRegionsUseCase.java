package com.example.roma.patientapp.domain.usecase;

import com.example.roma.patientapp.data.DataRepository;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.domain.usecase.base.UseCase;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.disposables.CompositeDisposable;

/**
 * Created by Romisaa on 6/18/2018.
 */

public class AllRegionsUseCase extends UseCase<RegionResponse> {

    @Inject
    public AllRegionsUseCase(CompositeDisposable compositeDisposable, DataRepository dataRepository) {
        super(compositeDisposable, dataRepository);
    }

    @Override
    protected Observable<RegionResponse> buildUseCaseObservable(Map<String, Object> parameters) {
        return dataRepository.getALlRegions();
    }

    public void saveRegionResponse(RegionResponse regionResponse) {
        dataRepository.saveRegionResponse(regionResponse);
    }
}
