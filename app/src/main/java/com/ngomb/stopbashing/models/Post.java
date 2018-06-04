
package com.ngomb.stopbashing.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Post {

    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("author_first_name")
    @Expose
    private String authorFirstName;
    @SerializedName("review")
    @Expose
    private Integer review;
    @SerializedName("is_ack_by_child")
    @Expose
    private Boolean isAckByChild;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("image_url")
    @Expose
    private String imageUrl;
    @SerializedName("latitude")
    @Expose
    private String latitude;
    @SerializedName("longitude")
    @Expose
    private String longitude;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Post() {
    }

    /**
     * 
     * @param id
     * @param imageUrl
     * @param createdAt
     * @param isAckByChild
     * @param longitude
     * @param latitude
     * @param authorFirstName
     * @param review
     */
    public Post(Integer id, String authorFirstName, Integer review, Boolean isAckByChild, String createdAt, String imageUrl, String latitude, String longitude) {
        super();
        this.id = id;
        this.authorFirstName = authorFirstName;
        this.review = review;
        this.isAckByChild = isAckByChild;
        this.createdAt = createdAt;
        this.imageUrl = imageUrl;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAuthorFirstName() {
        return authorFirstName;
    }

    public void setAuthorFirstName(String authorFirstName) {
        this.authorFirstName = authorFirstName;
    }

    public Integer getReview() {
        return review;
    }

    public void setReview(Integer review) {
        this.review = review;
    }

    public Boolean getIsAckByChild() {
        return isAckByChild;
    }

    public void setIsAckByChild(Boolean isAckByChild) {
        this.isAckByChild = isAckByChild;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

}
