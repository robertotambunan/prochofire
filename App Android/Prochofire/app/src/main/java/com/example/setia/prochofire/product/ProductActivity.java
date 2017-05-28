package com.example.setia.prochofire.product;

import android.content.Intent;
import android.os.Build;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.support.v7.graphics.Palette;
import android.transition.Slide;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.setia.prochofire.BaseApp;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.feature.FeatureActivity;
import com.example.setia.prochofire.model.Product;
import com.example.setia.prochofire.review.ReviewActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProductActivity extends AppCompatActivity implements ProductView{

    @BindView(R.id.header_product_image)
    public ImageView productImage;
    @BindView(R.id.iv_pelapak_image)
    public ImageView pelapakImage;
    @BindView(R.id.tv_product_name)
    public TextView productName;
    @BindView(R.id.btn_review_selengkapnya)
    public Button reviewSelengkapnya;
    @BindView(R.id.rv_product_review)
    public RecyclerView rvProductReview;

    private RecyclerView.LayoutManager productLayoutManager;
    private FeatureAdapter featureAdapter;
    private ProductPresenter presenter;
    private Product product;
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApp)getApplication()).getDeps().inject(this);
        initActivityTransitions();
        renderView();
    }

    public void renderView(){
        setContentView(R.layout.activity_product);
        ButterKnife.bind(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getData();
        presenter = new ProductPresenter(this, this, product);
        String itemTitle = product.getName();
        collapsingToolbarLayout = (CollapsingToolbarLayout) findViewById(R.id.collapsing_toolbar);
        collapsingToolbarLayout.setTitle(itemTitle);
        collapsingToolbarLayout.setExpandedTitleColor(getResources().getColor(android.R.color.transparent));
        Glide.with(this).load(product.getImages()).into(productImage);
        Glide.with(this).load(product.getSellerAvatar()).into(pelapakImage);
        productName.setText(product.getName());
        reviewSelengkapnya.setOnClickListener(v -> {
            Intent intent = new Intent(this, ReviewActivity.class);
            intent.putExtra("product", product);
            startActivity(intent);
        });
        productLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        rvProductReview.setLayoutManager(productLayoutManager);
        featureAdapter = new FeatureAdapter(this);
        rvProductReview.setAdapter(featureAdapter);
        rvProductReview.addOnItemTouchListener(presenter.getNewClickListener());
        featureAdapter.swapData(product.getFeatures());
    }

    public void getData(){
        Intent intent = getIntent();
        product = (Product) intent.getParcelableExtra("product");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_product, menu);
        return true;
    }

    private void initActivityTransitions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Slide transition = new Slide();
            transition.excludeTarget(android.R.id.statusBarBackground, true);
            getWindow().setEnterTransition(transition);
            getWindow().setReturnTransition(transition);
        }
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            return super.dispatchTouchEvent(motionEvent);
        } catch (NullPointerException e) {
            return false;
        }
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
}
