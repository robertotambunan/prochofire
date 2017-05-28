package com.example.setia.prochofire.review;

import com.example.setia.prochofire.model.Product;
import com.example.setia.prochofire.model.Review;

import java.util.List;

/**
 * Created by Setia on 5/27/2017.
 */

public interface ReviewView {

    void changeData(List<Review> reviewsDataSet);
    void toastMessage(String message);

}
