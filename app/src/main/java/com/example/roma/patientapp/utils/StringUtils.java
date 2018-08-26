package com.example.roma.patientapp.utils;

public class StringUtils {

    public static boolean isNull(String value) {
        return value == null ? true : false;
    }

    public static boolean isNullEmpty(String value) {
        return value == null || value == "" ? true : false;
    }

}
