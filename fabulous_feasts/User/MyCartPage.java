package com.example.fabulous_feasts.User;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.fabulous_feasts.Adapter.OrderedItemsAdapter;
import com.example.fabulous_feasts.Database.DatabaseHelper;
import com.example.fabulous_feasts.Models.OrderedItemsModel;
import com.example.fabulous_feasts.R;

import java.util.ArrayList;
import java.util.List;

public class MyCartPage extends AppCompatActivity implements OrderedItemsAdapter.OnCartItemChangeListener {

    TextView totalTxt;
    EditText orderName, address, contact;
    Button btnConfirm;
    RecyclerView recyclerView;
    OrderedItemsAdapter orderedItemsAdapter;
    List<OrderedItemsModel> orderedItemsList;

    DatabaseHelper databaseHelper;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_cart_page);

        totalTxt = findViewById(R.id.totalTxt);
        orderName = findViewById(R.id.orderName);
        address = findViewById(R.id.address);
        contact = findViewById(R.id.contact);
        recyclerView = findViewById(R.id.recyclerOrderedItems);
        btnConfirm = findViewById(R.id.btnConfirmOrder);

        databaseHelper = new DatabaseHelper(this);

        orderedItemsList = generateSampleData();
        orderedItemsAdapter = new OrderedItemsAdapter(this, orderedItemsList, this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderedItemsAdapter);

        updateTotal();

        btnConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String total = totalTxt.getText().toString();
                String orderNameText = orderName.getText().toString();
                String addressText = address.getText().toString();
                String contactText = contact.getText().toString();

                if (orderNameText.isEmpty() || addressText.isEmpty() || contactText.isEmpty()) {
                    Toast.makeText(MyCartPage.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                } else {
                    addOrderToDatabase(orderNameText, total, addressText, contactText);
                    Toast.makeText(MyCartPage.this, "Order Made Successfully!", Toast.LENGTH_SHORT).show();

                    Intent intent = new Intent(MyCartPage.this, OrderListPage.class);
                    intent.putExtra("total", total);
                    intent.putExtra("orderName", orderNameText);
                    intent.putExtra("address", addressText);
                    intent.putExtra("contact", contactText);
                    startActivity(intent);
                }
            }
        });
    }

    private void addOrderToDatabase(String orderName, String total, String address, String contact) {
        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("orderName", orderName);
        values.put("total", total);
        values.put("address", address);
        values.put("contact", contact);

        db.insert("orders", null, values);
        db.close();
    }

    @Override
    public void onCartItemChange() {
        updateTotal();
    }

    @SuppressLint("SetTextI18n")
    private void updateTotal() {
        double total = 0.0;
        for (OrderedItemsModel item : orderedItemsList) {
            double feeEach = Double.parseDouble(item.getFeeEach().replace("Rs.", ""));
            total += feeEach * item.getNumberOfItems();
        }
        totalTxt.setText("Total: Rs." + String.format("%.2f", total));
    }

    private List<OrderedItemsModel> generateSampleData() {
        List<OrderedItemsModel> data = new ArrayList<>();
        data.add(new OrderedItemsModel("Milk Rice", R.drawable.sri_lankan_kiribath_is_creamy__velvety__and_made_with_3_ingredients, "Rs.50", 2, 0));
        data.add(new OrderedItemsModel("Samosa", R.drawable.sri_lankan_fish_patties__fish_empanadas_, "Rs.70", 1, 0));
        data.add(new OrderedItemsModel("MilkShake", R.drawable.ic_milkshake, "Rs.60", 3, 0));
        return data;
    }
}
