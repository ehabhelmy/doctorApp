package com.example.roma.patientapp.utils;

import android.util.Log;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DateUtils {

    private Calendar calendar = Calendar.getInstance();

    public static String convertDayNumToString(String day) {
        String weekDay = null;
        switch (day) {
            case "1":
                weekDay = WeekDays.SATURDAY.getValue();
                break;
            case "2":
                weekDay = WeekDays.SUNDAY.getValue();
                break;
            case "3":
                weekDay = WeekDays.MONDAY.getValue();
                break;
            case "4":
                weekDay = WeekDays.TUESDAY.getValue();
                break;
            case "5":
                weekDay = WeekDays.WEDNESDAY.getValue();
                break;
            case "6":
                weekDay = WeekDays.THURSDAY.getValue();
                break;
            case "7":
                weekDay = WeekDays.FRIDAY.getValue();
                break;
        }
        return weekDay;
    }

    public static String getFormatedTime(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm aa");
        String outString = null;
        try {
            Date date = dateFormat.parse(time);
            outString = dateFormat2.format(date);
        } catch (ParseException e) {
            Log.i("error" , e.getMessage());
        }

        return outString;
    }

    public static String getFormatedTimeUpdate(String time) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh");
        SimpleDateFormat dateFormat2 = new SimpleDateFormat("hh:mm");
        String outString = null;
        try {
            Date date = dateFormat2.parse(time);
            outString = dateFormat.format(date);
        } catch (ParseException e) {
            Log.i("error" , e.getMessage());
        }

        return outString;
    }
}


enum WeekDays {
    SATURDAY("Saturday"),
    SUNDAY("Sunday"),
    MONDAY("Monday"),
    TUESDAY("Tuesday"),
    WEDNESDAY("Wednesday"),
    THURSDAY("Thursday"),
    FRIDAY("Friday");

    String value;

    WeekDays(String value) {
        this.value = value;
    }

    String getValue() {
        return value;
    }
}