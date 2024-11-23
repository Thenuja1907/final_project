// OrderedItemsAdapter.java

package com.example.fabulous_feasts.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fabulous_feasts.Models.OrderedItemsModel;
import com.example.fabulous_feasts.R;

import java.util.List;

public class OrderedItemsAdapter extends RecyclerView.Adapter<OrderedItemsAdapter.OrderedItemsViewHolder> {

    Context context;
    List<OrderedItemsModel> ordereditemsList;
    OnCartItemChangeListener cartItemChangeListener;

    public OrderedItemsAdapter(Context context, List<OrderedItemsModel> ordereditemsList, OnCartItemChangeListener cartItemChangeListener) {
        this.context = context;
        this.ordereditemsList = ordereditemsList;
        this.cartItemChangeListener = cartItemChangeListener;
    }

    @NonNull
    @Override
    public OrderedItemsAdapter.OrderedItemsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.user_cart_list, parent, false);
        return new OrderedItemsAdapter.OrderedItemsViewHolder(view);
    }

    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onBindViewHolder(@NonNull OrderedItemsAdapter.OrderedItemsViewHolder holder, int position) {
        OrderedItemsModel orderedItemsModel = ordereditemsList.get(position);
        holder.title.setText(orderedItemsModel.getOrderName());
        holder.pic.setImageResource(orderedItemsModel.getImageUrl());
        holder.feeEachItem.setText(orderedItemsModel.getFeeEach());
        holder.numberOfItem.setText(String.valueOf(orderedItemsModel.getNumberOfItems()));
        int numberOfItems = orderedItemsModel.getNumberOfItems();
        double feeEach = Double.parseDouble(orderedItemsModel.getFeeEach().replace("Rs.", ""));
        double total = numberOfItems * feeEach;
        holder.totalEachItem.setText("Rs." + String.format("%.2f", total));

        // Plus button click listener
        holder.plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newNumberOfItems = orderedItemsModel.getNumberOfItems() + 1;
                orderedItemsModel.setNumberOfItems(newNumberOfItems);
                holder.numberOfItem.setText(String.valueOf(newNumberOfItems));

                // Update total cost
                double newTotal = newNumberOfItems * feeEach;
                holder.totalEachItem.setText("Rs." + String.format("%.2f", newTotal));
                cartItemChangeListener.onCartItemChange();
            }
        });

        holder.minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int newNumberOfItems = orderedItemsModel.getNumberOfItems() - 1;
                if (newNumberOfItems >= 0) {
                    orderedItemsModel.setNumberOfItems(newNumberOfItems);
                    holder.numberOfItem.setText(String.valueOf(newNumberOfItems));

                    // Update total cost
                    double newTotal = newNumberOfItems * feeEach;
                    holder.totalEachItem.setText("Rs." + String.format("%.2f", newTotal));
                    cartItemChangeListener.onCartItemChange();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return ordereditemsList.size();
    }

    public interface OnCartItemChangeListener {
        void onCartItemChange();
    }

    public static final class OrderedItemsViewHolder extends RecyclerView.ViewHolder {
        TextView title, feeEachItem, totalEachItem, numberOfItem;
        ImageView pic, plus, minus;

        public OrderedItemsViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            numberOfItem = itemView.findViewById(R.id.numberItemTxt);
            pic = itemView.findViewById(R.id.pic);
            plus = itemView.findViewById(R.id.plusCartBtn);
            minus = itemView.findViewById(R.id.minusCartBtn);
        }
    }
}
