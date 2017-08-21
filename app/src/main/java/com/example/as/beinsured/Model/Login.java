package com.example.as.beinsured.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by as on 18.07.2017.
 */

public class Login {

    @SerializedName("apiKey")
    private String apiKey;
    @SerializedName("login")
    private String login;
    @SerializedName("password")
    private String password;

    public Login(String apiKey, String login, String password) {
        this.apiKey = apiKey;
        this.login = login;
        this.password = password;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


}
