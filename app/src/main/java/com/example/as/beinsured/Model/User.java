package com.example.as.beinsured.Model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by as on 18.07.2017.
 */

public class User {


    @SerializedName("error")
    private String error;
    @SerializedName("status")
    private Integer status;
    @SerializedName("message")
    private String message;
    @SerializedName("login")
    private String login;
    @SerializedName("email")
    private String email;
    @SerializedName("full_name")
    private String fullName;
    @SerializedName("login_token")
    private String loginToken;
    @SerializedName("login_token_exp")
    private String loginTokenExp;
    @SerializedName("refresh_token")
    private String refreshToken;
    @SerializedName("refresh_token_exp")
    private String refreshTokenExp;

    @Override
    public String toString() {
        return "User{" +
                "error='" + error + '\'' +
                ", status=" + status +
                ", message='" + message + '\'' +
                ", login='" + login + '\'' +
                ", email='" + email + '\'' +
                ", fullName='" + fullName + '\'' +
                ", loginToken='" + loginToken + '\'' +
                ", loginTokenExp='" + loginTokenExp + '\'' +
                ", refreshToken='" + refreshToken + '\'' +
                ", refreshTokenExp='" + refreshTokenExp + '\'' +
                '}';
    }

    public User(String error, Integer status, String message, String login, String email, String fullName, String loginToken, String loginTokenExp, String refreshToken, String refreshTokenExp) {
        this.error = error;
        this.status = status;
        this.message = message;
        this.login = login;
        this.email = email;
        this.fullName = fullName;
        this.loginToken = loginToken;
        this.loginTokenExp = loginTokenExp;
        this.refreshToken = refreshToken;
        this.refreshTokenExp = refreshTokenExp;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getLoginToken() {
        return loginToken;
    }

    public void setLoginToken(String loginToken) {
        this.loginToken = loginToken;
    }

    public String getLoginTokenExp() {
        return loginTokenExp;
    }

    public void setLoginTokenExp(String loginTokenExp) {
        this.loginTokenExp = loginTokenExp;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }

    public String getRefreshTokenExp() {
        return refreshTokenExp;
    }

    public void setRefreshTokenExp(String refreshTokenExp) {
        this.refreshTokenExp = refreshTokenExp;
    }
}
