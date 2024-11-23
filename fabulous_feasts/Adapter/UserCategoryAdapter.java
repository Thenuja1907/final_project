package com.example.fabulous_feasts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fabulous_feasts.Models.UserCategoryModel;
import com.example.fabulous_feasts.R;

import java.util.List;

public class UserCategoryAdapter extends RecyclerView.Adapter<UserCategoryAdapter.CategoryViewHolder> {
    Context context;
    List<UserCategoryModel> categoryList;
    OnCategoryClickListener listener;

    public UserCategoryAdapter(Context context, List<UserCategoryModel> categoryList, OnCategoryClickListener listener) {
        this.context = context;
        this.categoryList = categoryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public UserCategoryAdapter.CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_category_list, parent, false);
        return new CategoryViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UserCategoryAdapter.CategoryViewHolder holder, int position) {
        UserCategoryModel userCategory = categoryList.get(position);
        holder.categoryImageView.setImageResource(userCategory.getImageResId());
        holder.categoryTextView.setText(userCategory.getCategoryName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    listener.onCategoryClick(userCategory);
                }
            }
        });
    }


    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public interface OnCategoryClickListener {
        void onCategoryClick(UserCategoryModel userCategory);
    }

    public static class CategoryViewHolder extends RecyclerView.ViewHolder {
        ImageView categoryImageView;
        TextView categoryTextView;

        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            categoryImageView = itemView.findViewById(R.id.categoryImage1);
            categoryTextView = itemView.findViewById(R.id.categoryName1);
        }
    }
}
