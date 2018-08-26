package com.example.roma.patientapp.presentation.doctor_details;

import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.presentation.base.BaseView;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsModel;

/**
 * Created by Romisaa on 6/18/2018.
 */

public interface DoctorDetailsContract {

    interface View extends BaseView{

        void loadData(DoctorDetailsModel doctorDetailModel);
    }

    interface Presenter {
        void getDoctorDetails(Doctor doctor);
    }
}
