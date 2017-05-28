package com.example.setia.prochofire;

import android.app.Application;
import android.content.Context;

import com.example.setia.prochofire.deps.DaggerDeps;
import com.example.setia.prochofire.deps.Deps;
import com.example.setia.prochofire.module.NetworkModule;

/**
 * Created by Setia on 5/24/2017.
 */

public class BaseApp extends Application {
    Deps deps;

    public BaseApp get(Context context){
        return (BaseApp)context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        deps = DaggerDeps
                .builder()
                .networkModule(new NetworkModule())
                .build();
        deps.inject(this);
    }

    public Deps getDeps() {
        return deps;
    }
}

