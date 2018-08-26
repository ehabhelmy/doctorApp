package com.example.roma.patientapp.utils;


import com.example.roma.patientapp.BuildConfig;

import timber.log.Timber;

public class LogUtils {

    public static void init() {
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
        }
    }

    public static void d(String msg, Object... args) {
        Timber.d(msg, args);
    }

    public static void d(Throwable throwable, String msg, Object... args) {
        Timber.d(throwable, msg, args);
    }

    public static void i(String msg, Object... args) {
        Timber.i(msg, args);
    }

    public static void i(Throwable throwable, String msg, Object... args) {
        Timber.i(throwable, msg, args);
    }

    public static void w(String msg, Object... args) {
        Timber.w(msg, args);
    }

    public static void w(Throwable throwable, String msg, Object... args) {
        Timber.w(throwable, msg, args);
    }

    public static void e(String msg, Object... args) {
        Timber.e(msg, args);
    }

    public static void e(Throwable throwable, String msg, Object... args) {
        Timber.e(throwable, msg, args);
    }

}
