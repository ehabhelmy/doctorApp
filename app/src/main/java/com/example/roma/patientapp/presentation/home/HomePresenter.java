package com.example.roma.patientapp.presentation.home;

import com.example.roma.patientapp.data.model.appointments.RequestStatusResponse;
import com.example.roma.patientapp.data.model.regions.RegionResponse;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.data.model.search_doctor.SearchDoctorResponse;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.domain.usecase.AllRegionsUseCase;
import com.example.roma.patientapp.domain.usecase.AllSpecialitiesUseCase;
import com.example.roma.patientapp.domain.usecase.FinishRequestUseCase;
import com.example.roma.patientapp.domain.usecase.RequestApproveUseCase;
import com.example.roma.patientapp.domain.usecase.RequestRejectUseCase;
import com.example.roma.patientapp.domain.usecase.RequestStatusUseCase;
import com.example.roma.patientapp.domain.usecase.SearchDoctorUseCase;
import com.example.roma.patientapp.domain.usecase.base.DefaultObserver;
import com.example.roma.patientapp.domain.usecase.base.GetAllRequestUseCase;
import com.example.roma.patientapp.presentation.base.BasePresenter;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.Request;
import com.example.roma.patientapp.utils.constants.Constants;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.inject.Inject;

/**
 * Created by Romisaa on 6/15/2018.
 */

public class HomePresenter extends BasePresenter<HomeActivity> implements HomeContract.Presenter {

    private RequestStatusUseCase requestStatusUseCase;
    private GetAllRequestUseCase getAllRequestUseCase;
    private FinishRequestUseCase finishRequestUseCase;
    private RequestApproveUseCase requestApproveUseCase;
    private RequestRejectUseCase requestRejectUseCase;
    private ArrayList<Request> allRequests = new ArrayList<>();
    private ArrayList<Request> pendingRequests = new ArrayList<>();
    private ArrayList<Request> approvedRequests = new ArrayList<>();
    private ArrayList<Request> cancelledRequests = new ArrayList<>();
    private int count = 0;

    @Inject
    public HomePresenter(RequestStatusUseCase requestStatusUseCase, GetAllRequestUseCase getAllRequestUseCase, FinishRequestUseCase finishRequestUseCase, RequestApproveUseCase requestApproveUseCase, RequestRejectUseCase requestRejectUseCase) {
        this.requestStatusUseCase = requestStatusUseCase;
        this.getAllRequestUseCase = getAllRequestUseCase;
        this.finishRequestUseCase = finishRequestUseCase;
        this.requestApproveUseCase = requestApproveUseCase;
        this.requestRejectUseCase = requestRejectUseCase;
    }

    @Override
    public void navigateToEditProfileFragment() {
        navigationManager.navigateToEditProfileFragment();
    }

    @Override
    public void navigateToAppointmentsFragment() {
        navigationManager.navigateToAppointmentsFragment();
    }

    @Override
    public void navigateToSettingsFragment() {
        navigationManager.navigateToSettingsFragment();
    }

    @Override
    public void navigateToLogOutFragment() {
        navigationManager.navigateToLogOutFragment();
    }

    @Override
    public void navigateToAboutFragment() {
        navigationManager.navigateToAboutFragment();
    }

    @Override
    public void getAppointmentsRequests() {
        getAllRequestUseCase.execute(null, new DefaultObserver<AppointmentRequestDetailModel>() {
            @Override
            public void onNext(AppointmentRequestDetailModel appointmentRequestDetailModel) {
                super.onNext(appointmentRequestDetailModel);
                if (isViewAttached()) {
                    if (appointmentRequestDetailModel.getId() == 0) {
                        List<Request> requests = appointmentRequestDetailModel.getRequests();
                        if (requests != null) {
                            allRequests = (ArrayList<Request>) requests;
                            for (Request request : allRequests) {
                                getRequestStatus(request);
                            }
                        }
                    }else {
                        getView().showError(appointmentRequestDetailModel.getDescription());
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

    @Override
    public void onRequestApproved(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.REQUEST_ID, id);
        requestApproveUseCase.execute(params, new DefaultObserver<RequestStatusResponse>() {
            @Override
            public void onNext(RequestStatusResponse requestStatusResponse) {
                super.onNext(requestStatusResponse);
                if (isViewAttached() && requestStatusResponse.getId() == 0){
                    getView().approveSuccess();
                }else {
                    getView().showError(requestStatusResponse.getDescription());
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

    @Override
    public void onRequestRejected(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.REQUEST_ID, id);
        requestRejectUseCase.execute(params, new DefaultObserver<RequestStatusResponse>() {
            @Override
            public void onNext(RequestStatusResponse requestStatusResponse) {
                super.onNext(requestStatusResponse);
                if (isViewAttached() && requestStatusResponse.getId() == 0){
                    getView().rejectSuccess();
                }else {
                    getView().showError(requestStatusResponse.getDescription());
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

    @Override
    public void onRequestFinished(String id) {
        Map<String, Object> params = new HashMap<>();
        params.put(Constants.REQUEST_ID, id);
        finishRequestUseCase.execute(params, new DefaultObserver<RequestStatusResponse>() {
            @Override
            public void onNext(RequestStatusResponse requestStatusResponse) {
                super.onNext(requestStatusResponse);
                if (isViewAttached() && requestStatusResponse.getId() == 0){
                    getView().finishSuccess();
                }else {
                    getView().showError(requestStatusResponse.getDescription());
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

    private void getRequestStatus(final Request request) {
        count++;
        switch (request.getStatus()) {
            case Constants.REQUEST_STATUS_PENDING:
                pendingRequests.add(request);
                break;
            case Constants.REQUEST_STATUS_APPROVED:
                approvedRequests.add(request);
                break;
            case Constants.REQUEST_STATUS_CANCELLED:
            case Constants.REQUEST_STATUS_FINISHED:
                cancelledRequests.add(request);
                break;
            default:
                break;
        }
        isServiceFinished();
    }


    private void isServiceFinished() {
        if (count == allRequests.size()) {
            getView().loadDate(allRequests, pendingRequests, approvedRequests, cancelledRequests);
        }
    }

}
