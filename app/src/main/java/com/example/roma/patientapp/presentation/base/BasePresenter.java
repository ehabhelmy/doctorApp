package com.example.roma.patientapp.presentation.base;

import com.example.roma.patientapp.presentation.navigation.BaseNavigationManager;

import java.lang.ref.WeakReference;

/**
 * Created by Romisaa on 6/13/2018.
 */

public abstract class BasePresenter<T extends BaseView> {

    private WeakReference<T> view;

    protected BaseNavigationManager navigationManager = BaseNavigationManager.getInstance();

    public void setView(T view) {
        if (view == null) {
            throw new NullPointerException("view must not be null");
        }
        this.view = new WeakReference<T>(view);
    }

    public T getView() {
        return this.view.get() == null ? null : view.get();
    }


    public void detachView() {
        if (this.view.get() != null) {
            this.view.clear();
        }
    }

    public boolean isViewAttached() {
        return this.view == null ? false : true;
    }

}
