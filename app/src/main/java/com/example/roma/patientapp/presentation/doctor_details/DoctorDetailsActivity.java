package com.example.roma.patientapp.presentation.doctor_details;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.ActionBar;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.presentation.base.BaseActivity;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsModel;
import com.example.roma.patientapp.utils.constants.Constants;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class DoctorDetailsActivity extends BaseActivity implements DoctorDetailsContract.View {

    @BindView(R.id.fName_tv)
    TextView fName;
    @BindView(R.id.lName_tv)
    TextView lName;
    @BindView(R.id.speciality_tv)
    TextView speciality;
    @BindView(R.id.price_tv)
    TextView price;
    @BindView(R.id.days_tv)
    TextView days;
    @BindView(R.id.time_tv)
    TextView time;
    @BindView(R.id.first_day_tv)
    TextView firstAvaliableDay;
    @BindView(R.id.first_time_tv)
    TextView firstAvaliableTime;
    @BindView(R.id.address)
    TextView address;
    @BindView(R.id.rating_tv)
    TextView rating;
    @BindView(R.id.fab)
    FloatingActionButton fab;
    @Inject
    DoctorDetailsPresenter doctorDetailsPresenter;

    private Doctor doctor;
    private DoctorDetailsModel doctorDetailsModel;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_doctor_details;
    }

    @Override
    protected void initView() {
        super.initView();
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close);
        actionBar.setTitle("");
        doctor = (Doctor) getIntent().getParcelableExtra(Constants.DOCTOR);
    }

    @OnClick(R.id.fab)
    void navigateToBookAppointmentActivity() {
        if (doctorDetailsModel != null) {
            navigationManager.navigateToBookAppointmentActivity(doctorDetailsModel);
        }
    }

    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = doctorDetailsPresenter;
        doctorDetailsPresenter.setView(this);
        doctorDetailsPresenter.getDoctorDetails(doctor);
    }

    @Override
    public void loadData(DoctorDetailsModel model) {
        doctorDetailsModel = model;
        fName.setText(model.getLastName());
        price.setText("Fees " + model.getPrice() + " EGP" + "(" + model.getDiscount() + "% " + "Discount)");
        address.setText(model.getAddress());
        rating.setText(model.getRate());
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }
}
