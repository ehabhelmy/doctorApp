package com.example.roma.patientapp.data.model.login;

import com.example.roma.patientapp.data.model.BaseModel;

/**
 * Created by Romisaa on 6/13/2018.
 */

public class SignInResponse extends BaseModel{

    private Integer id;
    private String description;
    private String token;
    private UserInfo userInfo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserInfo getUserInfo() {
        return userInfo;
    }

    public void setUserInfo(UserInfo userInfo) {
        this.userInfo = userInfo;
    }

}
