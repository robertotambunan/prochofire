package com.example.setia.prochofire.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Setia on 5/24/2017.
 */

public class Response {
    @SerializedName("error")
    @Expose
    private Boolean error;
    @SerializedName("products")
    @Expose
    private List<Product> products = null;
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;

    public Boolean getError() {
        return error;
    }

    public void setError(Boolean error) {
        this.error = error;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }
}
