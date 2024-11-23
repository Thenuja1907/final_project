// OrderListPage.java

package com.example.fabulous_feasts.User;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.example.fabulous_feasts.R;

public class OrderListPage extends AppCompatActivity {

    TextView totalTxt, orderNameTxt, addressTxt, contactTxt;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_list_page);

        totalTxt = findViewById(R.id.totalTxt);
        orderNameTxt = findViewById(R.id.orderNameTxt);
        addressTxt = findViewById(R.id.addressTxt);
        contactTxt = findViewById(R.id.contactTxt);

        // Get data from Intent
        Intent intent = getIntent();
        String total = intent.getStringExtra("total");
        String orderName = intent.getStringExtra("orderName");
        String address = intent.getStringExtra("address");
        String contact = intent.getStringExtra("contact");

        // Set data to TextViews
        totalTxt.setText(total);
        orderNameTxt.setText(orderName);
        addressTxt.setText(address);
        contactTxt.setText(contact);
    }
}
