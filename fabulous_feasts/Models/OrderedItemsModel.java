package com.example.fabulous_feasts.Models;

public class OrderedItemsModel {
    String orderName;
    Integer imageUrl;
    String feeEach;
    Integer totalEach;
    Integer numberOfItems;

    public OrderedItemsModel(String orderName, Integer imageUrl, String feeEach, Integer totalEach, Integer numberOfItems) {
        this.orderName = orderName;
        this.imageUrl = imageUrl;
        this.feeEach = feeEach;
        this.totalEach = totalEach;
        this.numberOfItems = numberOfItems;
    }

    public String getOrderName() {
        return orderName;
    }

    public void setOrderName(String orderName) {
        this.orderName = orderName;
    }

    public Integer getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getFeeEach() {
        return feeEach;
    }

    public void setFeeEach(String feeEach) {
        this.feeEach = feeEach;
    }

    public Integer getTotalEach() {
        return totalEach;
    }

    public void setTotalEach(Integer totalEach) {
        this.totalEach = totalEach;
    }

    public Integer getNumberOfItems() {
        return numberOfItems;
    }

    public void setNumberOfItems(Integer numberOfItems) {
        this.numberOfItems = numberOfItems;
    }
}
