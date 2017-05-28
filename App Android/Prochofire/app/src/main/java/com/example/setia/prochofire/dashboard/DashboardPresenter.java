package com.example.setia.prochofire.dashboard;

import android.util.Log;
import android.widget.Toast;

import com.example.setia.prochofire.apihelper.API;
import com.example.setia.prochofire.apihelper.APIClient;
import com.example.setia.prochofire.model.Response;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Setia on 5/25/2017.
 */

public class DashboardPresenter {
    private DashboardView view;
    private APIClient apiClient;

    public DashboardPresenter(DashboardView view, APIClient apiClient){
        this.view = view;
        this.apiClient = apiClient;
    }

    public void loadAllProduct(){
        Log.d("getTest", "test");
        apiClient.get().getAllProduct().enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(!response.body().getError()){
                    Log.d("getTest", "test1");
                    view.changeData(response.body().getProducts());
                } else {
                    Log.d("getTest", "test2");
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                    view.toastMessage(t.getMessage());
            }
        });
    }

}
