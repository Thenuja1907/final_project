package com.example.fabulous_feasts.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.fabulous_feasts.Models.OrderModel;
import com.example.fabulous_feasts.R;

import java.util.List;

public class OrderListAdapter extends RecyclerView.Adapter<OrderListAdapter.OrderViewHolder> {

    Context context;
    List<OrderModel> orderList;

    public OrderListAdapter(Context context, List<OrderModel> orderList) {
        this.context = context;
        this.orderList = orderList;
    }

    @NonNull
    @Override
    public OrderViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.order_item, parent, false);
        return new OrderViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderViewHolder holder, int position) {
        OrderModel order = orderList.get(position);
        holder.orderName.setText(order.getOrderName());
        holder.total.setText("Total: " + order.getTotal());
        holder.address.setText("Address: " + order.getAddress());
        holder.contact.setText("Contact: " + order.getContact());
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    public static class OrderViewHolder extends RecyclerView.ViewHolder {
        TextView orderName, total, address, contact;

        public OrderViewHolder(@NonNull View itemView) {
            super(itemView);
            orderName = itemView.findViewById(R.id.orderName);
            total = itemView.findViewById(R.id.total);
            address = itemView.findViewById(R.id.address);
            contact = itemView.findViewById(R.id.contact);
        }
    }
}
