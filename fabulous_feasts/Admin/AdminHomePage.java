package com.example.fabulous_feasts.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.fabulous_feasts.Admin.Management.OrderManagementPage;
import com.example.fabulous_feasts.Admin.Management.ProductManagement;
import com.example.fabulous_feasts.R;

public class AdminHomePage extends AppCompatActivity {
    Button btnPM,btnOM;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_home_page);

        btnPM = findViewById(R.id.btnPM);
        btnOM = findViewById(R.id.btnOrderManage);

        btnPM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ProductManagement.class);
                startActivity(intent);
            }
        });
        btnOM.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), OrderManagementPage.class);
                startActivity(intent);
            }
        });

    }
}