package com.example.setia.prochofire.dashboard;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.setia.prochofire.R;
import com.example.setia.prochofire.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Setia on 5/26/2017.
 */

public class ProductAdapter extends BaseAdapter {
    private List<Product> mItems = new ArrayList<Product>();
    private LayoutInflater mInflater;
    private Context mContext;

    public ProductAdapter(Context context) {
        mContext = context;
        mInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mItems.size();
    }

    @Override
    public Product getItem(int i) {
        return mItems.get(i);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        final Product produk = getItem(i);
        final ViewHolder viewHolder;

        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = mInflater.inflate(R.layout.grid_product_item, viewGroup, false);
            viewHolder.picture = (ImageView) convertView.findViewById(R.id.iv_product_image);
            viewHolder.name = (TextView) convertView.findViewById(R.id.tv_product_name);
            viewHolder.pelapak = (TextView) convertView.findViewById(R.id.tv_product_pelapak);
            convertView.setTag(viewHolder);
        } else {
            //menggunakan item yang sudah pernah dibuat
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Glide.with(mContext).load(produk.getImages()).into(viewHolder.picture);
        viewHolder.name.setText(produk.getName());
        viewHolder.pelapak.setText(produk.getSellerName());

        return convertView;
    }

    static class ViewHolder {
        public TextView name;
        public TextView pelapak;
        public ImageView picture;
    }

    public void swapData(List<Product> dataSet){
        this.mItems.clear();
        this.mItems.addAll(dataSet);
        notifyDataSetChanged();
    }
}
