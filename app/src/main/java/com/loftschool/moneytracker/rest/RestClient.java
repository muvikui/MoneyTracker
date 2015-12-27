package com.loftschool.moneytracker.rest;

import retrofit.RestAdapter;

/**
 * Created by Muvikui on 21.12.2015.
 */
public class RestClient {
    private static final String BASE_URL = "http://lmt.loftblog.tmweb.ru/";
    private RegisterUserApi registerUserApi;

    public RestClient() {
        RestAdapter restAdapter = new RestAdapter.Builder().setEndpoint(BASE_URL).setLogLevel(RestAdapter.LogLevel.FULL).build();
        registerUserApi = restAdapter.create(RegisterUserApi.class);
        //loginUserApi = restAdapter.Create
    }

    public RegisterUserApi getRegisterUserApi() {
        return registerUserApi;
    }
}
