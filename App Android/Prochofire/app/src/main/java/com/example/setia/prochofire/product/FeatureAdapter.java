package com.example.setia.prochofire.product;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.model.Feature;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Setia on 5/27/2017.
 */

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.ViewHolder> {

    private List<Feature> dataSet = new ArrayList<Feature>();
    private Context context;

    public FeatureAdapter(List<Feature> dataSet){
        this.dataSet = dataSet;
    }

    public FeatureAdapter(Context context){
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        android.view.View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.rv_feature_item, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.category.setText(dataSet.get(position).getCategory());
        holder.positive.setText(dataSet.get(position).getPositive() + "");
        holder.neutral.setText(dataSet.get(position).getNetral() + "");
        holder.negative.setText(dataSet.get(position).getNegative() + "");
        Log.d("getTest", dataSet.get(position).getPositive() + " " + dataSet.get(position).getNetral() + " " + dataSet.get(position).getNegative());
        Glide.with(context).load(dataSet.get(position).getImageUrl()).into(holder.categoryImage);
    }

    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView category;
        public ImageView categoryImage;
        public TextView positive;
        public TextView neutral;
        public TextView negative;

        public ViewHolder(android.view.View itemView) {
            super(itemView);
            category = (TextView) itemView.findViewById(R.id.tv_feature_name);
            categoryImage = (ImageView) itemView.findViewById(R.id.iv_feature_image);
            positive = (TextView) itemView.findViewById(R.id.tv_feature_positive);
            neutral = (TextView) itemView.findViewById(R.id.tv_feature_neutral);
            negative = (TextView) itemView.findViewById(R.id.tv_feature_negative);
        }
    }

    public void swapData(List<Feature> dataSet){
        this.dataSet.clear();
        this.dataSet.addAll(dataSet);
        notifyDataSetChanged();
    }
}
