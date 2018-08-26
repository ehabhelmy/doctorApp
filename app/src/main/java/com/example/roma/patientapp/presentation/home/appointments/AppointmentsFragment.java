package com.example.roma.patientapp.presentation.home.appointments;


import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.TextView;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.doctor_details.DoctorAppointment;
import com.example.roma.patientapp.presentation.base.BaseFragment;
import com.example.roma.patientapp.presentation.home.book_appointment.AppointmentBookedActivity;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentsAdapter;
import com.example.roma.patientapp.utils.DateUtils;
import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.CalendarMode;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

import static com.example.roma.patientapp.PatientApplication.getContext;

public class AppointmentsFragment extends BaseFragment implements AppointmentsContract.View {

    @Inject
    AppointmentsPresenter appointmentsPresenter;
    @BindView(R.id.calendarView)
    AppCompatSpinner daySpinner;
    @BindView(R.id.from_spinner)
    AppCompatSpinner fromSpinner;
    @BindView(R.id.to_spinner)
    AppCompatSpinner toSpinner;
    @BindView(R.id.hours_count)
    TextView hoursCount;
    @BindView(R.id.date_tv)
    TextView dateTv;
    @BindView(R.id.appointment_rl)
    RecyclerView recyclerView;

    private AppointmentsAdapter adapter;
    private String day;
    private String from;
    private String to;
    private String[] times ;
    private ArrayList<DoctorAppointment> doctorAppointments = new ArrayList<>();

    private void setupAppointmentsRV() {
        RecyclerView.LayoutManager manager = new LinearLayoutManager(getActivity());
        DividerItemDecoration itemDecoration = new DividerItemDecoration(getActivity(),
                DividerItemDecoration.VERTICAL);
        adapter = new AppointmentsAdapter(new ArrayList<DoctorAppointment>());
        recyclerView.setLayoutManager(manager);
        recyclerView.addItemDecoration(itemDecoration);
        recyclerView.setAdapter(adapter);
    }


    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        super.presenter = appointmentsPresenter;
        appointmentsPresenter.setView(this);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_add_appointment;
    }

    @Override
    protected void initView() {
        super.initView();
        times = getResources().getStringArray(R.array.time_array);
        daySpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                day = position+1+"";
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        fromSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                from = DateUtils.getFormatedTimeUpdate(times[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        toSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                to = DateUtils.getFormatedTimeUpdate(times[position]);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
        setupAppointmentsRV();
    }

    @OnClick({R.id.add, R.id.submit})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.add:
                DoctorAppointment doctorAppointment = new DoctorAppointment(day,from,to);
                doctorAppointments.add(doctorAppointment);
                adapter.updateData(doctorAppointments);
                break;
            case R.id.submit:
                appointmentsPresenter.addAppointments(doctorAppointments);
                break;
        }
    }

    @Override
    public void showSuccess() {
        new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.success))
                .setMessage(getString(R.string.submitted))
                .show();

    }
}
