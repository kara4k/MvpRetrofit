package com.kara4k.mvpretrofit.model.impl;

import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kara4k.mvpretrofit.model.ApiIF;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiProvider {

    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/";

    public static ApiIF createApiIF() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build();
        return retrofit.create(ApiIF.class);
    }

    @NonNull
    private static Gson getGson() {
        return new GsonBuilder()
                .setLenient()
                .create();
    }

}
