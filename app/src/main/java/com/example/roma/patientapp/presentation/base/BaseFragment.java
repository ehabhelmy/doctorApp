package com.example.roma.patientapp.presentation.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.roma.patientapp.R;
import com.example.roma.patientapp.presentation.navigation.BaseNavigationManager;

import java.util.ArrayList;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * Created by Romisaa on 6/13/2018.
 */

public abstract class BaseFragment extends Fragment implements BaseView {

    private Unbinder unbinder;
    private View view;
    protected BasePresenter presenter;
    protected BaseNavigationManager navigationManager;
    protected FragmentManager fragmentManager;

    @Override
    public void showError(String msg) {
        new AlertDialog.Builder(getActivity())
                .setTitle(getString(R.string.failure))
                .setMessage(msg)
                .show();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        fragmentManager = getActivity().getSupportFragmentManager();
        navigationManager = BaseNavigationManager.getInstance();
        navigationManager.setCurrentActivity((BaseActivity) getActivity());
        initializeDagger();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(getLayoutId(), container, false);
        bindViews();
        initView();
        initializePresenter();
        return view;
    }

    protected void initView(){}

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (unbinder != null) {
            unbinder.unbind();
            unbinder = null;
        }
        if (presenter != null) {
            presenter.detachView();
        }
    }

    private void bindViews() {
        unbinder = ButterKnife.bind(this, view);
    }

    protected abstract void initializeDagger();

    protected abstract void initializePresenter();

    protected abstract int getLayoutId();

}


