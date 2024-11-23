package com.example.fabulous_feasts.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabulous_feasts.R;

public class AdminLoginPage extends AppCompatActivity {
    EditText adminName,adminPassword;
    Button adminLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_login_page);

        adminName = findViewById(R.id.editTextAN);
        adminPassword = findViewById(R.id.editTextAP);
        adminLogin = findViewById(R.id.btnAdminLogin);
        adminLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = adminName.getText().toString();
                String password = adminPassword.getText().toString();

                if (username.isEmpty()||password.isEmpty()) {
                    Toast.makeText(AdminLoginPage.this, "Enter Username & Password", Toast.LENGTH_SHORT).show();
                }
                else if (username.equals("admin") && password.equals("admin")) {
                    Toast.makeText(AdminLoginPage.this, "Admin Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), AdminHomePage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(AdminLoginPage.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}