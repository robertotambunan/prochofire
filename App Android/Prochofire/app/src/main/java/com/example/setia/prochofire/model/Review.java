package com.example.setia.prochofire.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Setia on 5/24/2017.
 */

public class Review implements Parcelable{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sender_id")
    @Expose
    private String senderId;
    @SerializedName("sender_name")
    @Expose
    private String senderName;
    @SerializedName("sender_type")
    @Expose
    private String senderType;
    @SerializedName("rate")
    @Expose
    private String rate;
    @SerializedName("body")
    @Expose
    private String body;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("product")
    @Expose
    private Object product;
    @SerializedName("user_vote")
    @Expose
    private Object userVote;
    @SerializedName("product_id")
    @Expose
    private String productId;
    @SerializedName("positive_votes")
    @Expose
    private Object positiveVotes;
    @SerializedName("negative_votes")
    @Expose
    private Object negativeVotes;
    @SerializedName("sentimen")
    @Expose
    private String sentimen;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    protected Review(Parcel in) {
        id = in.readString();
        senderId = in.readString();
        senderName = in.readString();
        senderType = in.readString();
        rate = in.readString();
        body = in.readString();
        updatedAt = in.readString();
        productId = in.readString();
        sentimen = in.readString();
        features = in.createTypedArrayList(Feature.CREATOR);
    }

    public static final Creator<Review> CREATOR = new Creator<Review>() {
        @Override
        public Review createFromParcel(Parcel in) {
            return new Review(in);
        }

        @Override
        public Review[] newArray(int size) {
            return new Review[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSenderId() {
        return senderId;
    }

    public void setSenderId(String senderId) {
        this.senderId = senderId;
    }

    public String getSenderName() {
        return senderName;
    }

    public void setSenderName(String senderName) {
        this.senderName = senderName;
    }

    public String getSenderType() {
        return senderType;
    }

    public void setSenderType(String senderType) {
        this.senderType = senderType;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Object getProduct() {
        return product;
    }

    public void setProduct(Object product) {
        this.product = product;
    }

    public Object getUserVote() {
        return userVote;
    }

    public void setUserVote(Object userVote) {
        this.userVote = userVote;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Object getPositiveVotes() {
        return positiveVotes;
    }

    public void setPositiveVotes(Object positiveVotes) {
        this.positiveVotes = positiveVotes;
    }

    public Object getNegativeVotes() {
        return negativeVotes;
    }

    public void setNegativeVotes(Object negativeVotes) {
        this.negativeVotes = negativeVotes;
    }

    public String getSentimen() {
        return sentimen;
    }

    public void setSentimen(String sentimen) {
        this.sentimen = sentimen;
    }

    public List<Feature> getFeatures() {
        return features;
    }

    public void setFeatures(List<Feature> features) {
        this.features = features;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(senderId);
        dest.writeString(senderName);
        dest.writeString(senderType);
        dest.writeString(rate);
        dest.writeString(body);
        dest.writeString(updatedAt);
        dest.writeString(productId);
        dest.writeString(sentimen);
        dest.writeTypedList(features);
    }
}
