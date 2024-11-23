package com.example.fabulous_feasts.User;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.fabulous_feasts.R;

import java.io.IOException;

public class UserProfilePage extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;

    ImageView userImageView;
    TextView usernameTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile_page);

        userImageView = findViewById(R.id.User);
        usernameTextView = findViewById(R.id.Username);

        // Retrieve username from previous activity (replace with actual logic to fetch username)
        String username = getIntent().getStringExtra("userName");
        if (username != null) {
            usernameTextView.setText(username);
        } else {
            usernameTextView.setText("Unknown User");
        }

        userImageView.setOnClickListener(v -> openFileChooser());

        Button homeButton = findViewById(R.id.btnhm);
        Button myAccountButton = findViewById(R.id.MyAct);
        Button orderListButton = findViewById(R.id.Btn_list);
        Button settingsButton = findViewById(R.id.btn_stngs);

        homeButton.setOnClickListener(v -> openActivity(UserHomePage.class));

    }

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            Uri imageUri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), imageUri);
                userImageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void openActivity(Class<?> activityClass) {
        Intent intent = new Intent(this, activityClass);
        startActivity(intent);
    }
}
