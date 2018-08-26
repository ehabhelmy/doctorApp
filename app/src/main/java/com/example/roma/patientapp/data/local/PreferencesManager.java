package com.example.roma.patientapp.data.local;


import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class PreferencesManager {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    public PreferencesManager(SharedPreferences sharedPreferences) {
        this.sharedPreferences = sharedPreferences;
        this.editor = this.sharedPreferences.edit();
    }

    public String getString(String key) {
        return this.getString(key, (String) null);
    }

    public String getString(String key, String defaultValue) {
        return this.sharedPreferences.getString(key, defaultValue);
    }

    public void saveString(String key, String value) {
        this.editor.putString(key, value).commit();
    }

    public int getInt(String key, int defaultVal) {
        return this.sharedPreferences.getInt(key, defaultVal);
    }

    public void saveInt(String key, int value) {
        this.editor.putInt(key, value).commit();
    }

    public boolean getBoolean(String key) {
        return this.getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultValue) {
        return this.sharedPreferences.getBoolean(key, defaultValue);
    }

    public void saveBoolean(String key, boolean value) {
        this.editor.putBoolean(key, value).commit();
    }

    public long getLong(String key, long defaultValue) {
        return this.sharedPreferences.getLong(key, defaultValue);
    }

    public long getLong(String key) {
        return this.sharedPreferences.getLong(key, 0L);
    }

    public boolean contains(String key) {
        return this.sharedPreferences.contains(key);
    }

    public void removeEntry(String key) {
        this.editor.remove(key).commit();
    }

    public void clearSharedPreferences() {
        this.sharedPreferences.edit().clear().commit();
    }

    public void saveObject(String key, Object object) {
        editor.putString(key, new Gson().toJson(object));
        editor.commit();
    }

    public <Model> Model getObject(String key, Class<Model> modelClass) {
        String json = this.sharedPreferences.getString(key, null);
        Gson gson = new Gson();
        return gson.fromJson(json, modelClass);
    }

    public <T> void setList(String key, List<T> list) {
        this.editor.putString(key, new Gson().toJson(list));
        editor.commit();
    }

    public <T> List<T> getList(String key, Class<T> cls) {
        List<T> list = new ArrayList<T>();
        String json = this.getString(key, null);
        try {
            list = new Gson().fromJson(json, new TypeToken<List<T>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public  <T>  List<T> getList(String key,Type type) {
        if (this.getString(key,null) != null) {
            return new Gson().fromJson(this.getString(key, null), type);
        }else {
            return null;
        }
    }
}

