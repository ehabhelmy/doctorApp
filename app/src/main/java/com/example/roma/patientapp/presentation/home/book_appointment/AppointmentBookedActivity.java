package com.example.roma.patientapp.presentation.home.book_appointment;

import android.content.DialogInterface;
import android.graphics.Color;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;
import com.example.roma.patientapp.presentation.base.BaseActivity;
import com.example.roma.patientapp.presentation.doctor_details.adapter.DoctorDetailsModel;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentsAdapter;
import com.example.roma.patientapp.utils.constants.Constants;

import javax.inject.Inject;

import butterknife.BindView;

import static com.example.roma.patientapp.PatientApplication.getContext;

public class AppointmentBookedActivity extends BaseActivity implements AppointmentBookedContract.View{

    @BindView(R.id.all_appointments_rv)
    RecyclerView appointmentsRV;

    @Inject
    AppointmentBookedPresenter appointmentBookedPresenter;

    private DoctorDetailsModel doctorDetailsModel;
    private AppointmentsAdapter adapter;


    @Override
    protected void initView() {
        super.initView();
        doctorDetailsModel = (DoctorDetailsModel) getIntent().getParcelableExtra(Constants.DOCTOR);
        setupToolbar();
    }

    private void setupToolbar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_close);
        actionBar.setTitle(Constants.Appointment);
    }


    @Override
    protected int getLayoutId() {
        return R.layout.activity_appointment_booked;
    }

    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = appointmentBookedPresenter;
        appointmentBookedPresenter.setView(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return true;
    }

    public interface OnItemClickListener {
        void onItemClick(DoctorAppointment appointment);
    }

}


