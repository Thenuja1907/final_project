package com.example.fabulous_feasts.Manager;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabulous_feasts.R;

public class ManagerLoginPage extends AppCompatActivity {

    EditText managerName,managerPassword;
    Button managerLogin;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_manager_login_page);
        managerName = findViewById(R.id.editTextMN);
        managerPassword = findViewById(R.id.editTextMP);
        managerLogin = findViewById(R.id.btnManagerLogin);
        managerLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = managerName.getText().toString();
                String password = managerPassword.getText().toString();

                if (username.isEmpty()||password.isEmpty()) {
                    Toast.makeText(ManagerLoginPage.this, "Enter Username & Password", Toast.LENGTH_SHORT).show();
                }
                else if (username.equals("manager") && password.equals("manager")) {
                    Toast.makeText(ManagerLoginPage.this, "Manager Login Successful!", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), ManagerHomePage.class);
                    startActivity(intent);
                }
                else {
                    Toast.makeText(ManagerLoginPage.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}