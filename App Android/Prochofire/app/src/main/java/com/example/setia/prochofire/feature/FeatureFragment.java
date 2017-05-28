package com.example.setia.prochofire.feature;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.setia.prochofire.R;
import com.example.setia.prochofire.model.Review;
import com.example.setia.prochofire.review.ReviewAdapter;

import java.util.ArrayList;
import java.util.List;

public class FeatureFragment extends Fragment {

    private static final String ARG_CONTENT = "content";

    private String content;
    private RecyclerView rvReview;
    private RecyclerView.LayoutManager reviewLayoutManager;
    private ReviewAdapter reviewAdapter;
    private List<Review> dataSet;

    public FeatureFragment() {
        // Required empty public constructor
    }

    public static FeatureFragment newInstance(ArrayList<Review> content) {
        FeatureFragment fragment = new FeatureFragment();
        Bundle args = new Bundle();
        args.putParcelableArrayList(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            dataSet = getArguments().getParcelableArrayList(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View convertView = inflater.inflate(R.layout.fragment_feature, container, false);
        rvReview = (RecyclerView) convertView.findViewById(R.id.rv_review_feature);
        reviewLayoutManager = new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false);
        rvReview.setLayoutManager(reviewLayoutManager);
        reviewAdapter = new ReviewAdapter(getContext());
        rvReview.setAdapter(reviewAdapter);
        reviewAdapter.swapData(dataSet);
        return convertView;
    }
}
