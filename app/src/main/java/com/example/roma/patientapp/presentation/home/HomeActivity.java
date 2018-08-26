package com.example.roma.patientapp.presentation.home;

import android.content.res.ColorStateList;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.roma.patientapp.PatientApplication;
import com.example.roma.patientapp.R;
import com.example.roma.patientapp.data.model.search_doctor.Doctor;
import com.example.roma.patientapp.presentation.base.BaseActivity;
import com.example.roma.patientapp.presentation.home.appointments.adapter.AppointmentsAdapter;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.AppointmentRequestDetailModel;
import com.example.roma.patientapp.presentation.home.book_appointment.adapter.Request;
import com.example.roma.patientapp.presentation.home.search_doctor.SearchDoctorAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.OnClick;

public class HomeActivity extends BaseActivity implements HomeContract.View,AppointmentsAdapter.OnAppointmentAction {

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.nav_drawer)
    DrawerLayout drawerLayout;
    @BindView(R.id.nav_view)
    NavigationView navigationView;
    @Inject
    HomePresenter homePresenter;
    @BindView(R.id.all_requests_tv)
    TextView allRequestsTv;
    @BindView(R.id.pending_requests_tv)
    TextView pendingRequestsTv;
    @BindView(R.id.approved_requests_tv)
    TextView approvedRequestsTv;
    @BindView(R.id.cancelled_requests_tv)
    TextView cancelledRequestsTv;
    @BindView(R.id.appointments_rv)
    RecyclerView appointmentsRv;

    private ArrayList<Request> allRequests;
    private ArrayList<Request> pendingRequests;
    private ArrayList<Request> approvedRequests;
    private ArrayList<Request> cancelledRequests;
    private AppointmentsAdapter adapter;
    private ColorStateList oldColors;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
    }

    @Override
    protected void initView() {
        super.initView();
        oldColors =  approvedRequestsTv.getTextColors(); //save original colors
        setSupportActionBar(toolbar);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        adapter = new AppointmentsAdapter();
        adapter.setOnAppointmentAction(this);
        appointmentsRv.setLayoutManager(mLayoutManager);
        appointmentsRv.addItemDecoration(itemDecoration);
        appointmentsRv.setAdapter(adapter);
        appointmentsRv.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initializeDagger() {
        PatientApplication.getComponenet().inject(this);
    }

    @Override
    protected void initializePresenter() {
        presenter = homePresenter;
        homePresenter.setView(this);
        homePresenter.getAppointmentsRequests();
        handleNavigation();
    }

    @OnClick(R.id.menu_iv)
    void openNavigationDrawer() {
        drawerLayout.openDrawer(GravityCompat.START);
    }



    private void handleNavigation() {

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                drawerLayout.closeDrawers();
                switch (item.getItemId()) {
                    case R.id.profile_item:
                        homePresenter.navigateToEditProfileFragment();
                        break;
                    case R.id.appoint_item:
                        homePresenter.navigateToAppointmentsFragment();
                        break;
                    case R.id.setting_item:
                        homePresenter.navigateToSettingsFragment();
                        break;
                    case R.id.logout_item:
                        homePresenter.navigateToLogOutFragment();
                        break;
                    case R.id.about_item:
                        homePresenter.navigateToAboutFragment();
                        break;
                }
                return false;
            }
        });

    }

    @Override
    public void loadDate(ArrayList<Request> allRequests,
                         ArrayList<Request> pendingRequests,
                         ArrayList<Request> approvedRequests,
                         ArrayList<Request> cancelledRequests) {

        this.allRequests = allRequests;
        this.pendingRequests = pendingRequests;
        this.approvedRequests = approvedRequests;
        this.cancelledRequests = cancelledRequests;
        renderRecyclarViewData(this.allRequests);
    }

    @Override
    public void approveSuccess() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.success))
                .setMessage(getString(R.string.approved))
                .show();
    }

    @Override
    public void rejectSuccess() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.success))
                .setMessage(getString(R.string.rejected))
                .show();
    }

    @Override
    public void finishSuccess() {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.success))
                .setMessage(getString(R.string.finished))
                .show();
    }

    void renderRecyclarViewData(ArrayList<Request> data) {
        adapter.updateData(data);
    }

    @OnClick(R.id.all_requests_tv)
    void getAllRequests() {
        allRequestsTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        pendingRequestsTv.setTextColor(oldColors);
        approvedRequestsTv.setTextColor(oldColors);
        cancelledRequestsTv.setTextColor(oldColors);
        adapter.updateData(allRequests);
    }

    @OnClick(R.id.pending_requests_tv)
    void getPendingRequests() {
        allRequestsTv.setTextColor(oldColors);
        pendingRequestsTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        approvedRequestsTv.setTextColor(oldColors);
        cancelledRequestsTv.setTextColor(oldColors);
        adapter.updateData(pendingRequests);
    }

    @OnClick(R.id.approved_requests_tv)
    void getApprovedRequests() {
        allRequestsTv.setTextColor(oldColors);
        pendingRequestsTv.setTextColor(oldColors);
        approvedRequestsTv.setTextColor(getResources().getColor(R.color.colorPrimary));
        cancelledRequestsTv.setTextColor(oldColors);
        adapter.updateData(approvedRequests);
    }

    @OnClick(R.id.cancelled_requests_tv)
    void getCancelledRequests() {
        allRequestsTv.setTextColor(oldColors);
        pendingRequestsTv.setTextColor(oldColors);
        approvedRequestsTv.setTextColor(oldColors);
        cancelledRequestsTv.setTextColor(oldColors);
        adapter.updateData(cancelledRequests);
    }

    @Override
    public void onRequestApproved(String id) {
        homePresenter.onRequestApproved(id);
    }

    @Override
    public void onRequestRejected(String id) {
        homePresenter.onRequestRejected(id);
    }

    @Override
    public void onRequestFinished(String id) {
        homePresenter.onRequestFinished(id);
    }
}
