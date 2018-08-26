package com.example.roma.patientapp.presentation.doctor_details.adapter;

import com.example.roma.patientapp.data.model.doctor_details.DoctorDetailsResponse;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.data.model.specialities.SpecialitiesResponse;
import com.example.roma.patientapp.data.model.specialities.Speciality;

/**
 * Created by Romisaa on 6/18/2018.
 */

public class DoctorDetailsAdapter {

    private DoctorDetailsModel model;

    public DoctorDetailsModel getDoctorDetailModel(Doctor searchedDoctor, DoctorDetailsResponse doctorDetailsResponse, SpecialitiesResponse specialities) {
        model = new DoctorDetailsModel();
        model.setMedicalCode(searchedDoctor.getMedicalCode());
        model.setLastName(searchedDoctor.getLastName());
        model.setAddress(searchedDoctor.getServiceProvider().getAddress());
        model.setPrice(doctorDetailsResponse.getServices().get(0).getPrice());
        model.setDiscount(doctorDetailsResponse.getServices().get(0).getDiscountPercentage());
        model.setRate(searchedDoctor.getRate());
        model.setSpeciality(getSpecialityName(doctorDetailsResponse.getServices().get(0).getSpeciality(), specialities));
        model.setImageLocation(searchedDoctor.getImageLocation());
        model.setMobileNumber(searchedDoctor.getMobileNumber());
        model.setLocation(searchedDoctor.getServiceProvider().getLocation());
        model.setServiceProvider(searchedDoctor.getServiceProvider());
        model.setDoctorAppointments(doctorDetailsResponse.getDoctorAppointments());
        model.setServices(doctorDetailsResponse.getServices());
        return model;
    }

    private String getSpecialityName(String specialityId, SpecialitiesResponse specialitiesResponse) {
        if (specialitiesResponse == null) return null;

        for (Speciality speciality : specialitiesResponse.getSpecialities()) {
            if (speciality.getId().equals(specialityId)) {
                return speciality.getName();
            }
        }
        return null;
    }
}
