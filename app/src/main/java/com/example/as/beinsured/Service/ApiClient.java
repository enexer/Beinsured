package com.example.as.beinsured.Service;

import com.example.as.beinsured.Model.Account;
import com.example.as.beinsured.Model.NewsletterDetails;
import com.example.as.beinsured.Model.NewsletterPage;
import com.example.as.beinsured.Model.User;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by as on 18.07.2017.
 */

public interface ApiClient {

    @GET("DefaultProfil/getListaNewsleter")
    Call<NewsletterPage> getNewsletterList(
            @Query("apiKey") String apiKey,
            @Query("page") String page,
            @Header("Authorization") String authToken
    );


    @GET("DefaultProfil/getNewsleter")
    Call<NewsletterDetails> getNewsletter(
            @Query("apiKey") String apiKey,
            @Query("newsletter") String newsletter,
            @Header("Authorization") String authToken
    );



    @GET("DefaultProfil/getPakiet")
    Call<Account> getAccount(
            @Query("apiKey") String apiKey,
            @Header("Authorization") String authToken
    );

    @FormUrlEncoded
    @POST("RestAuth/refresh/")
    Call<User> refresh(
            @Field("apiKey") String apiKey,
            @Header("Authorization") String authToken
    );

    @FormUrlEncoded
    @POST("RestAuth/SignIn/")
    Call<User> login(
            @Field("apiKey") String apiKey,
            @Field("login") String login,
            @Field("password") String password
    );
}


