package com.example.setia.prochofire.deps;

import com.example.setia.prochofire.BaseApp;
import com.example.setia.prochofire.apihelper.APIClient;
import com.example.setia.prochofire.dashboard.DashboardActivity;
import com.example.setia.prochofire.feature.FeatureActivity;
import com.example.setia.prochofire.module.NetworkModule;
import com.example.setia.prochofire.product.ProductActivity;
import com.example.setia.prochofire.review.ReviewActivity;
import com.example.setia.prochofire.review.ReviewPresenter;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Setia on 5/24/2017.
 */

@Singleton
@Component(modules = {NetworkModule.class})
public interface Deps {

    void inject(BaseApp baseApp);
    void inject(DashboardActivity activity);
    void inject(ProductActivity activity);
    void inject(ReviewActivity activity);
    void inject(FeatureActivity activity);

    APIClient apiClient();
}
