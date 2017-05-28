package com.example.setia.prochofire.dashboard;

import com.example.setia.prochofire.model.Product;

import java.util.List;

/**
 * Created by Setia on 5/25/2017.
 */

public interface DashboardView {
    void changeData(List<Product> dataSet);
    void toastMessage(String message);
}
