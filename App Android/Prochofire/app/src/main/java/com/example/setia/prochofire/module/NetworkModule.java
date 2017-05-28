package com.example.setia.prochofire.module;

import com.example.setia.prochofire.apihelper.APIClient;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Setia on 5/24/2017.
 */

@Module
public class NetworkModule {
    private APIClient apiClient;

    public NetworkModule() {
        apiClient = new APIClient();
        apiClient.setupRestClient();
    }

    @Provides
    @Singleton
    APIClient provideAPIClient(){
        return apiClient;
    }
}
