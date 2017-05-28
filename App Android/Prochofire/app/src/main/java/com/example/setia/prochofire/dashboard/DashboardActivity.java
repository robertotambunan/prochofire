package com.example.setia.prochofire.dashboard;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.Toast;

import com.example.setia.prochofire.BaseApp;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.apihelper.APIClient;
import com.example.setia.prochofire.model.Product;
import com.example.setia.prochofire.product.ProductActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class DashboardActivity extends AppCompatActivity implements DashboardView{

    @Inject
    public APIClient apiClient;

    @BindView(R.id.gv_products)
    GridView gvProducts;

    public ProductAdapter productAdapter;
    public DashboardPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApp)getApplication()).getDeps().inject(this);
        presenter = new DashboardPresenter(this, apiClient);
        renderView();
    }

    public void renderView(){
        setContentView(R.layout.activity_dashboard);
        ButterKnife.bind(this);

        productAdapter = new ProductAdapter(this);
        gvProducts.setAdapter(productAdapter);
        gvProducts.setOnItemClickListener((parent, view, position, id) -> {
            Product product = (Product) productAdapter.getItem(position);
            Intent intent = new Intent(this, ProductActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        });
        presenter.loadAllProduct();
    }

    @Override
    public void changeData(List<Product> dataSet) {
        productAdapter.swapData(dataSet);
    }

    @Override
    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
