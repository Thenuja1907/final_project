package com.example.fabulous_feasts.Admin.Management;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fabulous_feasts.Adapter.OrderListAdapter;
import com.example.fabulous_feasts.Database.DatabaseHelper;
import com.example.fabulous_feasts.Models.OrderModel;
import com.example.fabulous_feasts.R;

import java.util.List;

public class OrderManagementPage extends AppCompatActivity {

    RecyclerView recyclerView;
    OrderListAdapter orderListAdapter;
    List<OrderModel> orderList;
    DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_management_page);

        recyclerView = findViewById(R.id.recyclerOrderList);
        databaseHelper = new DatabaseHelper(this);

        loadOrders();

        orderListAdapter = new OrderListAdapter(this, orderList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderListAdapter);
    }

    private void loadOrders() {
        orderList = databaseHelper.getAllOrders();
    }
}
