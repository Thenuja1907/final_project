package com.example.fabulous_feasts.Admin.Management;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fabulous_feasts.Database.DatabaseHelper;
import com.example.fabulous_feasts.R;

public class DeleteProduct extends AppCompatActivity {
    EditText productIdEditText;
    Button deleteProductButton;
    DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_product);

        productIdEditText = findViewById(R.id.editTextProductId);
        deleteProductButton = findViewById(R.id.buttonDeleteProduct);

        databaseHelper = new DatabaseHelper(this);

        deleteProductButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteProductFromDatabase();
            }
        });
    }

    private void deleteProductFromDatabase() {
        int productId = Integer.parseInt(productIdEditText.getText().toString());

        SQLiteDatabase db = databaseHelper.getWritableDatabase();
        int rowsDeleted = db.delete("products", "id = ?", new String[]{String.valueOf(productId)});

        if (rowsDeleted > 0) {
            Toast.makeText(this, "Product deleted successfully!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Error deleting product. Please check the product ID.", Toast.LENGTH_SHORT).show();
        }
    }
}
