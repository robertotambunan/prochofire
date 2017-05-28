package com.example.setia.prochofire.review;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.dashboard.ProductAdapter;
import com.example.setia.prochofire.model.Product;
import com.example.setia.prochofire.model.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Setia on 5/28/2017.
 */

public class ReviewAdapter extends RecyclerView.Adapter<ReviewAdapter.ViewHolder> {

    private List<Review> dataSet = new ArrayList<Review>();
    private Context context;

    public ReviewAdapter(List<Review> dataSet){
        this.dataSet = dataSet;
    }

    public ReviewAdapter(Context context){
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        android.view.View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_review_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.reviewSender.setText("oleh " + dataSet.get(position).getSenderName());
        holder.reviewBody.setText(dataSet.get(position).getBody());
        holder.reviewFeatureLayoutManager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        holder.rvReviewFeature.setLayoutManager(holder.reviewFeatureLayoutManager);
        holder.reviewFeatureAdapter = new ReviewFeatureAdapter(context, dataSet.get(position).getSentimen());
        holder.rvReviewFeature.setAdapter(holder.reviewFeatureAdapter);
        holder.reviewFeatureAdapter.swapData(dataSet.get(position).getFeatures());
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView reviewSender;
        public TextView reviewBody;
        public RecyclerView rvReviewFeature;
        public RecyclerView.LayoutManager reviewFeatureLayoutManager;
        public ReviewFeatureAdapter reviewFeatureAdapter;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            reviewSender = (TextView) itemView.findViewById(R.id.tv_review_sender);
            reviewBody = (TextView) itemView.findViewById(R.id.tv_review_body);
            rvReviewFeature = (RecyclerView) itemView.findViewById(R.id.rv_review_feature);
        }
    }

    public void swapData(List<Review> dataSet){
        this.dataSet.clear();
        this.dataSet.addAll(dataSet);
        notifyDataSetChanged();
    }
}
