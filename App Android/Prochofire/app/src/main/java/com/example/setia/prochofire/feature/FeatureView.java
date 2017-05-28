package com.example.setia.prochofire.feature;

import com.example.setia.prochofire.model.Feature;
import com.example.setia.prochofire.model.Review;

import java.util.List;

/**
 * Created by Setia on 5/27/2017.
 */

public interface FeatureView {

    void initTab(List<Review> reviewsDataSet);
    void toastMessage(String message);
    Boolean checkFeature(Review review, String param);

}
