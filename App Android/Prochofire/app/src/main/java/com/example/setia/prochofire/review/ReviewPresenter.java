package com.example.setia.prochofire.review;

import com.example.setia.prochofire.apihelper.APIClient;
import com.example.setia.prochofire.model.Response;
import com.example.setia.prochofire.model.Review;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;

/**
 * Created by Setia on 5/27/2017.
 */

public class ReviewPresenter {

    private ReviewView view;
    private APIClient apiClient;

    public ReviewPresenter(ReviewView view, APIClient apiClient){
        this.view = view;
        this.apiClient = apiClient;
    }

    public void getReview(String productId){
        apiClient.get().getProductReview(productId).enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                if(!response.body().getError()){
                    view.changeData(response.body().getReviews());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                view.toastMessage(t.getMessage());
            }
        });
    }

}
