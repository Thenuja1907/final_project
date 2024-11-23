package com.example.fabulous_feasts.Models;

public class UserCategoryModel {
    Integer categoryId;
    String categoryName;
    Integer imageResId;

    public UserCategoryModel(Integer categoryId, Integer imageResId, String categoryName) {
        this.categoryId = categoryId;
        this.imageResId = imageResId;
        this.categoryName = categoryName;

    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {

        this.categoryName = categoryName;
    }

    public Integer getCategoryId() {

        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {

        this.categoryId = categoryId;
    }

    public Integer getImageResId() {
        return imageResId;
    }

    public void setImageResId(Integer imageResId) {

        this.imageResId = imageResId;
    }
}

