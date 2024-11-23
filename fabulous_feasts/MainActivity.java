package com.example.fabulous_feasts;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.example.fabulous_feasts.Admin.AdminLoginPage;
import com.example.fabulous_feasts.Manager.ManagerLoginPage;
import com.example.fabulous_feasts.User.UserWelcomePage;

public class MainActivity extends AppCompatActivity {
    Button btnUser,btnAdmin,btnManager;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUser = findViewById(R.id.btnUDB);
        btnUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserWelcomePage.class);
                startActivity(intent);
            }
        });
        btnAdmin = findViewById(R.id.btnADB);
        btnAdmin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), AdminLoginPage.class);
                startActivity(intent);
            }
        });
        btnManager = findViewById(R.id.btnMDB);
        btnManager.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), ManagerLoginPage.class);
                startActivity(intent);
            }
        });
    }
}