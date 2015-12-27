package com.loftschool.moneytracker.rest;

import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by Muvikui on 21.12.2015.
 */
public class RegisterUserApi {

    @GET("/auth")
    UserRegistrationModel registerUser(@Query("login") String login,
                                       @Query("password") String password,
                                       @Query("register") String register) {
        return null;
    }
}
