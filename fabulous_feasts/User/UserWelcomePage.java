package com.example.fabulous_feasts.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.example.fabulous_feasts.R;

public class UserWelcomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_welcome_page);

        // Used handler to delay the intent by 1 second
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(UserWelcomePage.this, Login_Page.class);
                finish();
                startActivity(intent);
            }
        }, 1000); // 1-second delay
    }
}
