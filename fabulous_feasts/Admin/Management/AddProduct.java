package com.example.fabulous_feasts.Admin.Management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabulous_feasts.Database.DatabaseHelper;
import com.example.fabulous_feasts.R;

public class AddProduct extends AppCompatActivity {
    EditText categoryIdEditText, productNameEditText, productAboutEditText, productQtyEditText, productPriceEditText, imageUrlEditText;
    Button addProductButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_product);

        categoryIdEditText = findViewById(R.id.editTextCategoryId);
        productNameEditText = findViewById(R.id.editTextProductName);
        productAboutEditText = findViewById(R.id.editTextProductAbout);
        productQtyEditText = findViewById(R.id.editTextProductQty);
        productPriceEditText = findViewById(R.id.editTextProductPrice);
        imageUrlEditText = findViewById(R.id.editTextImageUrl);
        addProductButton = findViewById(R.id.buttonAddProduct);

        databaseHelper = new DatabaseHelper(this);

        addProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addProductToDatabase();
            }
        });
    }

    private void addProductToDatabase() {
        int categoryId = Integer.parseInt(categoryIdEditText.getText().toString());
        String productName = productNameEditText.getText().toString();
        String productAbout = productAboutEditText.getText().toString();
        String productQty = productQtyEditText.getText().toString();
        String productPrice = productPriceEditText.getText().toString();
        int imageUrl = Integer.parseInt(imageUrlEditText.getText().toString());

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("categoryId", categoryId);
        values.put("productName", productName);
        values.put("productAbout", productAbout);
        values.put("productQty", productQty);
        values.put("productPrice", productPrice);
        values.put("imageUrl", imageUrl);

        long newRowId = db.insert("products", null, values);

        if (newRowId != -1) {
            Toast.makeText(this, "Product added successfully!", Toast.LENGTH_SHORT).show();
            clearFields();
        } else {
            Toast.makeText(this, "Error adding product.", Toast.LENGTH_SHORT).show();
        }
    }

    private void clearFields() {
        categoryIdEditText.setText("");
        productNameEditText.setText("");
        productAboutEditText.setText("");
        productQtyEditText.setText("");
        productPriceEditText.setText("");
        imageUrlEditText.setText("");
    }
}
