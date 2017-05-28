package com.example.setia.prochofire.review;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.model.Feature;
import com.example.setia.prochofire.model.Review;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Setia on 5/28/2017.
 */

public class ReviewFeatureAdapter extends RecyclerView.Adapter<ReviewFeatureAdapter.ViewHolder> {

    private List<Feature> dataSet = new ArrayList<Feature>();
    private String sentiment;
    private Context context;

    public ReviewFeatureAdapter(List<Feature> dataSet){
        this.dataSet = dataSet;
    }

    public ReviewFeatureAdapter(Context context, String sentiment){
        this.context = context;
        this.sentiment = sentiment;
    }

    public String getSentiment() {
        return sentiment;
    }

    public void setSentiment(String sentiment) {
        this.sentiment = sentiment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        android.view.View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_review_feature_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Glide.with(context).load(dataSet.get(position).getImageUrl()).into(holder.category);
        if(sentiment.equals("1")){
            holder.em.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_em_joyful));
        } else if (sentiment.equals("0")){
            holder.em.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_em_sceptic));
        } else if(sentiment.equals("-1")){
            holder.em.setImageDrawable(context.getResources().getDrawable(R.drawable.ic_em_sad));
        }
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView category;
        public ImageView em;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            category = (ImageView) itemView.findViewById(R.id.iv_feature_image);
            em = (ImageView) itemView.findViewById(R.id.iv_feature_em);
        }
    }

    public void swapData(List<Feature> dataSet){
        this.dataSet.clear();
        this.dataSet.addAll(dataSet);
        notifyDataSetChanged();
    }
}