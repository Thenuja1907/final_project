package com.example.fabulous_feasts.User;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.fabulous_feasts.Database.DatabaseHelper;
import com.example.fabulous_feasts.R;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.regex.Pattern;

public class UserSignUpPage extends AppCompatActivity {
    EditText editTextSName, editTextEmail, editTextSPW, editTextCPW, editTextContact;
    TextView textViewError;
    RadioGroup genderGroup;
    DatabaseHelper dbHelper;
    RadioButton selectedGender;
    Button btnRegister, btnGoToLogin;
    private static final String TAG = "UserSignUpPage";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_sign_up_page);

        editTextSName = findViewById(R.id.editTextSignName);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextSPW = findViewById(R.id.editTextSignPW);
        editTextCPW = findViewById(R.id.editTextCPW);
        editTextContact = findViewById(R.id.editTextContact);
        textViewError = findViewById(R.id.textViewSignUpError);
        genderGroup = findViewById(R.id.gender);

        dbHelper = new DatabaseHelper(this);

        btnGoToLogin = findViewById(R.id.btnGoToLogin);
        btnGoToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Login_Page.class);
                startActivity(intent);
            }
        });

        btnRegister = findViewById(R.id.btnRegister);
        btnRegister.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                String userName = editTextSName.getText().toString();
                int selectedRadioButtonId = genderGroup.getCheckedRadioButtonId();
                String userEmail = editTextEmail.getText().toString();
                String userContact = editTextContact.getText().toString();
                String userPassword = editTextSPW.getText().toString();
                String confirmPassword = editTextCPW.getText().toString();
                selectedGender = findViewById(selectedRadioButtonId);
                String gender = selectedGender != null ? selectedGender.getText().toString() : "";

                if (userName.isEmpty() || userEmail.isEmpty() || userPassword.isEmpty() || confirmPassword.isEmpty() || gender.isEmpty()) {
                    textViewError.setText("Please fill in all the fields!");
                } else if (!userPassword.equals(confirmPassword)) {
                    textViewError.setText("Passwords do not match!");
                } else if (!isValidContact(userContact)) {
                    textViewError.setText("Invalid Contact Number!");
                } else if (!isValidEmail(userEmail)) {
                    textViewError.setText("Invalid Email Address!");
                } else {
                    SQLiteDatabase db = null;
                    try {
                        db = dbHelper.getWritableDatabase();
                        ContentValues values = new ContentValues();
                        values.put("userName", userName);
                        values.put("email", userEmail);
                        values.put("gender", gender);
                        values.put("contactNo", userContact);
                        values.put("userPassword", hashPassword(userPassword));

                        long newRowId = db.insert("users", null, values);
                        if (newRowId != -1) {
                            Toast.makeText(UserSignUpPage.this, "Registration Successful!", Toast.LENGTH_LONG).show();
                            Intent intent = new Intent(UserSignUpPage.this, Login_Page.class);
                            startActivity(intent);
                            finish();
                        } else {
                            textViewError.setText("Registration Failed!");
                        }
                    } catch (Exception e) {
                        Log.e(TAG, "Error inserting new user", e);
                        textViewError.setText("Registration Failed! " + e.getMessage());
                    } finally {
                        if (db != null) {
                            db.close();
                        }
                    }
                }
            }
        });
    }

    private boolean isValidEmail(String email) {
        String emailPattern = "^[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+$";
        return Pattern.matches(emailPattern, email);
    }

    private boolean isValidContact(String contact) {
        String contactPattern = "^07\\d{8}$";
        return Pattern.matches(contactPattern, contact);
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] digest = md.digest(password.getBytes());
            StringBuilder sb = new StringBuilder();
            for (byte b : digest) {
                sb.append(String.format("%02x", b));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e) {
            Log.e(TAG, "No such algorithm for password hashing", e);
            return null;
        }
    }
}
