package com.example.fabulous_feasts.User;

import androidx.appcompat.app.AppCompatActivity;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabulous_feasts.R;
import com.example.fabulous_feasts.User.UserHomePage;
import com.example.fabulous_feasts.User.UserSignUpPage;

public class Login_Page extends AppCompatActivity {
    TextView textViewLoginError;
    EditText editUserName, editPassWord;
    Button btnLogin, btnGoToSU;
    CheckBox checkBoxRM;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        editUserName = findViewById(R.id.loginUsername);
        editPassWord = findViewById(R.id.loginPw);
        checkBoxRM = findViewById(R.id.checkBoxRM);
        textViewLoginError = findViewById(R.id.textViewLoginError);
        btnLogin = findViewById(R.id.btnLogin);
        btnGoToSU = findViewById(R.id.btnGotoSU);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String userName = editUserName.getText().toString();
                String password = editPassWord.getText().toString();

                // Assuming validation is done here
                if(userName.isEmpty()||password.isEmpty()){
                    textViewLoginError.setText("Enter User Name and Password");
                }else if (isValidUser(userName, editPassWord.getText().toString())) {
                    Toast.makeText(Login_Page.this, "User Login Successfully", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getApplicationContext(), UserHomePage.class);
                    intent.putExtra("userName", userName);
                    startActivity(intent);
                }
                else {
                    textViewLoginError.setText("Invalid username or password");
                }
            }
        });

        btnGoToSU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), UserSignUpPage.class);
                startActivity(intent);
            }
        });
    }

    private boolean isValidUser(String userName, String password) {
        // Perform user validation here (e.g., check against database)
        // For now, assume the user is valid
        return true;
    }
}
