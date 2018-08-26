package com.example.roma.patientapp.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;

import com.example.roma.patientapp.R;
import com.example.roma.patientapp.presentation.navigation.BaseNavigationManager;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Romisaa on 6/13/2018.
 */

public abstract class BaseActivity extends AppCompatActivity implements BaseView {

    private Unbinder unbinder;
    protected BasePresenter presenter;
    protected BaseNavigationManager navigationManager;

    @Override
    public void showError(String msg) {
        new AlertDialog.Builder(this)
                .setTitle(getString(R.string.failure))
                .setMessage(msg)
                .show();
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(this.getLayoutId());
        navigationManager = BaseNavigationManager.getInstance();
        navigationManager.getInstance().setCurrentActivity(this);
        navigationManager.getInstance().setFragmentManager(getSupportFragmentManager());
        bindViews();
        initView();
        initializeDagger();
        initializePresenter();
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        if (presenter != null) {
            presenter.detachView();
        }
    }

    protected void bindViews() {
        unbinder = ButterKnife.bind(this);
    }

    protected void initView() {
    }

    protected abstract int getLayoutId();

    protected abstract void initializeDagger();

    protected abstract void initializePresenter();

}
