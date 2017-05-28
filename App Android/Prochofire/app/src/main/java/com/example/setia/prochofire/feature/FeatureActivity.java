package com.example.setia.prochofire.feature;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.setia.prochofire.BaseApp;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.apihelper.APIClient;
import com.example.setia.prochofire.model.Feature;
import com.example.setia.prochofire.model.Product;
import com.example.setia.prochofire.model.Review;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeatureActivity extends AppCompatActivity implements FeatureView{

    @BindView(R.id.toolbar)
    public Toolbar toolbar;
    @BindView(R.id.tabs)
    public TabLayout tabs;
    @BindView(R.id.viewPager)
    public ViewPager viewPager;

    @Inject
    public APIClient apiClient;

    private FeaturePresenter presenter;
    private ArrayList<Review> featureBaterai = new ArrayList<Review>();
    private ArrayList<Review> featureLensa = new ArrayList<Review>();
    private ArrayList<Review> featureGoPro = new ArrayList<Review>();
    private ArrayList<Review> featurePackage = new ArrayList<Review>();
    private Product product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ((BaseApp)getApplication()).getDeps().inject(this);
        presenter = new FeaturePresenter(this, apiClient);
        renderView();
    }

    public void renderView(){
        setContentView(R.layout.activity_feature);
        ButterKnife.bind(this);
        getData();

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        presenter.loadData(product.getId());
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
    public void initTab(List<Review> reviewsDataSet) {
        for(int i = 0; i < reviewsDataSet.size(); i++){
            if(checkFeature(reviewsDataSet.get(i), "Baterai")){
                featureBaterai.add(reviewsDataSet.get(i));
            }
            if(checkFeature(reviewsDataSet.get(i), "Lensa")){
                featureLensa.add(reviewsDataSet.get(i));
            }
            if(checkFeature(reviewsDataSet.get(i), "Go Pro")){
                featureGoPro.add(reviewsDataSet.get(i));
            }
            if(checkFeature(reviewsDataSet.get(i), "Package")){
                featurePackage.add(reviewsDataSet.get(i));
            }
        }
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFragment(FeatureFragment.newInstance(featureBaterai), "Baterai");
        adapter.addFragment(FeatureFragment.newInstance(featureLensa), "Lensa");
        adapter.addFragment(FeatureFragment.newInstance(featureGoPro), "Go Pro");
        adapter.addFragment(FeatureFragment.newInstance(featurePackage), "Package");
        viewPager.setAdapter(adapter);
        tabs.getSelectedTabPosition();
        tabs.setupWithViewPager(viewPager);
    }

    @Override
    public void toastMessage(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public Boolean checkFeature(Review review, String param) {
        for(int i = 0; i < review.getFeatures().size(); i++){
            if(review.getFeatures().get(i).getCategory().equals(param)){
                return true;
            }
        }
        return false;
    }
}
