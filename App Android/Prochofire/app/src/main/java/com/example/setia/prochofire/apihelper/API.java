package com.example.setia.prochofire.apihelper;

import com.example.setia.prochofire.model.Response;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by Setia on 5/24/2017.
 */

public interface API {

    @GET("getProduct")
    Call<Response> getAllProduct();

    @GET("getProductReviewById/{product_id}")
    Call<Response> getProductReview(@Path("product_id") String productId);

}
