package com.example.fabulous_feasts.Models;

public class UserProductModel {
    Integer categoryId;
    Integer productId;
    String productName;
    String productAbout;
    String productQty;
    String productPrice;
    int imageUrl;

    public UserProductModel(Integer categoryId,Integer productId, String productName, String productAbout, String productQty, String productPrice, int imageUrl) {
        this.categoryId = categoryId;
        this.productId = productId;
        this.productName = productName;
        this.productAbout = productAbout;
        this.productQty = productQty;
        this.productPrice = productPrice;
        this.imageUrl = imageUrl;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public int getProductId() {
        return productId;
    }

    public String getProductName() {
        return productName;
    }

    public String getProductAbout() {
        return productAbout;
    }

    public String getProductQty() {
        return productQty;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public int getImageUrl() {
        return imageUrl;
    }
}
