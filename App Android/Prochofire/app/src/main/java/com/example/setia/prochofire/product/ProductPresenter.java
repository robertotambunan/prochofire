package com.example.setia.prochofire.product;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.example.setia.prochofire.feature.FeatureActivity;
import com.example.setia.prochofire.helper.RecyclerItemClickListener;
import com.example.setia.prochofire.model.Feature;
import com.example.setia.prochofire.model.Product;

/**
 * Created by Setia on 5/26/2017.
 */

public class ProductPresenter {

    private ProductView view;
    private Context context;
    private Product product;

    public ProductPresenter(ProductView view, Context context, Product product){
        this.view = view;
        this.context = context;
        this.product = product;
    }

    public RecyclerItemClickListener getNewClickListener(){
        return (new RecyclerItemClickListener(context, new RecyclerItemClickListener.OnItemClickListener(){
            @Override
            public void onItemClick(View view, int position) {
                Intent intent = new Intent(context, FeatureActivity.class);
                intent.putExtra("product", product);
                context.startActivity(intent);
            }
        }));
    }

}
