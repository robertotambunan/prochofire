package com.example.setia.prochofire.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Setia on 5/27/2017.
 */

public class Feature implements Parcelable {

    @SerializedName("category")
    @Expose
    private String category;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("positive")
    @Expose
    private String positive;
    @SerializedName("negative")
    @Expose
    private String negative;
    @SerializedName("netral")
    @Expose
    private String netral;

    protected Feature(Parcel in) {
        category = in.readString();
        imageUrl = in.readString();
        positive = in.readString();
        negative = in.readString();
        netral = in.readString();
    }

    public static final Creator<Feature> CREATOR = new Creator<Feature>() {
        @Override
        public Feature createFromParcel(Parcel in) {
            return new Feature(in);
        }

        @Override
        public Feature[] newArray(int size) {
            return new Feature[size];
        }
    };

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getPositive() {
        return positive;
    }

    public void setPositive(String positive) {
        this.positive = positive;
    }

    public String getNegative() {
        return negative;
    }

    public void setNegative(String negative) {
        this.negative = negative;
    }

    public String getNetral() {
        return netral;
    }

    public void setNetral(String netral) {
        this.netral = netral;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(category);
        dest.writeString(imageUrl);
        dest.writeString(positive);
        dest.writeString(negative);
        dest.writeString(netral);
    }
}
