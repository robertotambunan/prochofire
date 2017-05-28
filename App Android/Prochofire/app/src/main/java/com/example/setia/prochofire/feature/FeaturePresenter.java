package com.example.setia.prochofire.feature;

import com.example.setia.prochofire.apihelper.APIClient;
import com.example.setia.prochofire.model.Response;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Setia on 5/27/2017.
 */

public class FeaturePresenter {

    private FeatureView view;
    private APIClient apiClient;

    public FeaturePresenter(FeatureView view, APIClient apiClient){
        this.view = view;
        this.apiClient = apiClient;
    }

    public void loadData(String productId){
        apiClient.get().getProductReview(productId).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(!response.body().getError()){
                    view.initTab(response.body().getReviews());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                view.toastMessage(t.getMessage());
            }
        });
    }
}
