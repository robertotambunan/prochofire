package com.example.setia.prochofire.review;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.RatingBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.setia.prochofire.BaseApp;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.apihelper.APIClient;
import com.example.setia.prochofire.dashboard.DashboardPresenter;
import com.example.setia.prochofire.model.Product;
import com.example.setia.prochofire.model.Review;
import com.example.setia.prochofire.product.FeatureAdapter;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ReviewActivity extends AppCompatActivity implements ReviewView{

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.tv_product_rate)
    public TextView productRate;
    @BindView(R.id.tv_product_name)
    public TextView productName;
    @BindView(R.id.rb_product_rate)
    public RatingBar rbProductRate;
    @BindView(R.id.rv_review)
    public RecyclerView rvReview;

    @Inject
    public APIClient apiClient;

    private Product product;
    private ReviewPresenter presenter;
    private RecyclerView.LayoutManager reviewLayoutManager;
    private ReviewAdapter reviewAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApp)getApplication()).getDeps().inject(this);
        presenter = new ReviewPresenter(this, apiClient);
        renderView();
    }

    public void renderView(){
        setContentView(R.layout.activity_review);
        ButterKnife.bind(this);
        getData();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        productRate.setText(product.getAverageRate());
        productName.setText(product.getName());
        rbProductRate.setRating(Float.valueOf(product.getAverageRate()));
        reviewLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        rvReview.setLayoutManager(reviewLayoutManager);
        reviewAdapter = new ReviewAdapter(this);
        rvReview.setAdapter(reviewAdapter);
        presenter.getReview(product.getId());
    }

    public void getData(){
        Intent intent = getIntent();
        product = (Product)intent.getParcelableExtra("product");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @Override
    public void changeData(List<Review> reviewsDataSet) {
        reviewAdapter.swapData(reviewsDataSet);
    }

    @Override
    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
