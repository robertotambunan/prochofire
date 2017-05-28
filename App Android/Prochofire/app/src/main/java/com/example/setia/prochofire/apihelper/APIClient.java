package com.example.setia.prochofire.apihelper;

import javax.inject.Singleton;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Setia on 5/24/2017.
 */

@Singleton
public class APIClient {
    private API REST_CLIENT;
    private String URL= "http://apibukalapak.azurewebsites.net/index.php/";

    public APIClient() {
        // TODO Auto-generated constructor stub
    }

    public API get() {
        return REST_CLIENT;
    }

    public void setupRestClient() {
        Retrofit builder = new Retrofit.Builder()
                .baseUrl(URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        REST_CLIENT = builder.create(API.class);
    }
    public String getURL(){
        return URL;
    }
}
