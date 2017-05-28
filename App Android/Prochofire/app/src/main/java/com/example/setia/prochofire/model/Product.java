package com.example.setia.prochofire.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Setia on 5/24/2017.
 */

public class Product implements Parcelable{
    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("city")
    @Expose
    private String city;
    @SerializedName("province")
    @Expose
    private String province;
    @SerializedName("weight")
    @Expose
    private String weight;
    @SerializedName("images")
    @Expose
    private String images;
    @SerializedName("small_images")
    @Expose
    private String smallImages;
    @SerializedName("description")
    @Expose
    private String description;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("stock")
    @Expose
    private String stock;
    @SerializedName("favorited")
    @Expose
    private String favorited;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("seller_username")
    @Expose
    private String sellerUsername;
    @SerializedName("seller_name")
    @Expose
    private String sellerName;
    @SerializedName("seller_id")
    @Expose
    private String sellerId;
    @SerializedName("seller_avatar")
    @Expose
    private String sellerAvatar;
    @SerializedName("seller_level")
    @Expose
    private String sellerLevel;
    @SerializedName("seller_level_badge_url")
    @Expose
    private String sellerLevelBadgeUrl;
    @SerializedName("seller_delivery_time")
    @Expose
    private String sellerDeliveryTime;
    @SerializedName("seller_positive_feedback")
    @Expose
    private String sellerPositiveFeedback;
    @SerializedName("seller_negative_feedback")
    @Expose
    private String sellerNegativeFeedback;
    @SerializedName("seller_term_condition")
    @Expose
    private String sellerTermCondition;
    @SerializedName("top_merchant")
    @Expose
    private String topMerchant;
    @SerializedName("average_rate")
    @Expose
    private String averageRate;
    @SerializedName("features")
    @Expose
    private List<Feature> features = null;

    protected Product(Parcel in) {
        id = in.readString();
        name = in.readString();
        city = in.readString();
        province = in.readString();
        weight = in.readString();
        images = in.readString();
        smallImages = in.readString();
        description = in.readString();
        condition = in.readString();
        stock = in.readString();
        favorited = in.readString();
        createdAt = in.readString();
        updatedAt = in.readString();
        sellerUsername = in.readString();
        sellerName = in.readString();
        sellerId = in.readString();
        sellerAvatar = in.readString();
        sellerLevel = in.readString();
        sellerLevelBadgeUrl = in.readString();
        sellerDeliveryTime = in.readString();
        sellerPositiveFeedback = in.readString();
        sellerNegativeFeedback = in.readString();
        sellerTermCondition = in.readString();
        topMerchant = in.readString();
        averageRate = in.readString();
        features = in.createTypedArrayList(Feature.CREATOR);
    }

    public static final Creator<Product> CREATOR = new Creator<Product>() {
        @Override
        public Product createFromParcel(Parcel in) {
            return new Product(in);
        }

        @Override
        public Product[] newArray(int size) {
            return new Product[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getSmallImages() {
        return smallImages;
    }

    public void setSmallImages(String smallImages) {
        this.smallImages = smallImages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getFavorited() {
        return favorited;
    }

    public void setFavorited(String favorited) {
        this.favorited = favorited;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public String getSellerUsername() {
        return sellerUsername;
    }

    public void setSellerUsername(String sellerUsername) {
        this.sellerUsername = sellerUsername;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public String getSellerId() {
        return sellerId;
    }

    public void setSellerId(String sellerId) {
        this.sellerId = sellerId;
    }

    public String getSellerAvatar() {
        return sellerAvatar;
    }

    public void setSellerAvatar(String sellerAvatar) {
        this.sellerAvatar = sellerAvatar;
    }

    public String getSellerLevel() {
        return sellerLevel;
    }

    public void setSellerLevel(String sellerLevel) {
        this.sellerLevel = sellerLevel;
    }

    public String getSellerLevelBadgeUrl() {
        return sellerLevelBadgeUrl;
    }

    public void setSellerLevelBadgeUrl(String sellerLevelBadgeUrl) {
        this.sellerLevelBadgeUrl = sellerLevelBadgeUrl;
    }

    public String getSellerDeliveryTime() {
        return sellerDeliveryTime;
    }

    public void setSellerDeliveryTime(String sellerDeliveryTime) {
        this.sellerDeliveryTime = sellerDeliveryTime;
    }

    public String getSellerPositiveFeedback() {
        return sellerPositiveFeedback;
    }

    public void setSellerPositiveFeedback(String sellerPositiveFeedback) {
        this.sellerPositiveFeedback = sellerPositiveFeedback;
    }

    public String getSellerNegativeFeedback() {
        return sellerNegativeFeedback;
    }

    public void setSellerNegativeFeedback(String sellerNegativeFeedback) {
        this.sellerNegativeFeedback = sellerNegativeFeedback;
    }

    public String getSellerTermCondition() {
        return sellerTermCondition;
    }

    public void setSellerTermCondition(String sellerTermCondition) {
        this.sellerTermCondition = sellerTermCondition;
    }

    public String getTopMerchant() {
        return topMerchant;
    }

    public void setTopMerchant(String topMerchant) {
        this.topMerchant = topMerchant;
    }

    public String getAverageRate() {
        return averageRate;
    }

    public void setAverageRate(String averageRate) {
        this.averageRate = averageRate;
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
        dest.writeString(name);
        dest.writeString(city);
        dest.writeString(province);
        dest.writeString(weight);
        dest.writeString(images);
        dest.writeString(smallImages);
        dest.writeString(description);
        dest.writeString(condition);
        dest.writeString(stock);
        dest.writeString(favorited);
        dest.writeString(createdAt);
        dest.writeString(updatedAt);
        dest.writeString(sellerUsername);
        dest.writeString(sellerName);
        dest.writeString(sellerId);
        dest.writeString(sellerAvatar);
        dest.writeString(sellerLevel);
        dest.writeString(sellerLevelBadgeUrl);
        dest.writeString(sellerDeliveryTime);
        dest.writeString(sellerPositiveFeedback);
        dest.writeString(sellerNegativeFeedback);
        dest.writeString(sellerTermCondition);
        dest.writeString(topMerchant);
        dest.writeString(averageRate);
        dest.writeTypedList(features);
    }
}
