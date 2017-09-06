package com.kara4k.mvpretrofit;


import android.app.Application;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kara4k.mvpretrofit.model.ApiIF;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {

    private static final String ENDPOINT = "https://jsonplaceholder.typicode.com/";

    private static ApiIF sApiIF;

    @Override
    public void onCreate() {
        super.onCreate();
        Gson gson = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ENDPOINT)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        sApiIF = retrofit.create(ApiIF.class);
    }

    public static ApiIF getApi() {
        return sApiIF;
    }


}
