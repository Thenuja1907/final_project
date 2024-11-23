package com.example.fabulous_feasts.Database;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.fabulous_feasts.Models.OrderModel;

import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final String TAG = "DatabaseHelper";
    private static final String DATABASE_NAME = "fabulous_feasts_db";
    private static final int DATABASE_VERSION = 3;

    private static final String CREATE_USER_TABLE = "CREATE TABLE users " +
            "(user_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "userName TEXT, " +
            "email TEXT, " +
            "gender TEXT, " +
            "contactNo TEXT, " +
            "userPassword TEXT );";

    private static final String CREATE_PRODUCT_TABLE = "CREATE TABLE products " +
            "(product_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "categoryId INTEGER, " +
            "productName TEXT, " +
            "productAbout TEXT, " +
            "productQty TEXT, " +
            "productPrice TEXT, " +
            "imageUrl INTEGER );";

    private static final String CREATE_ORDER_TABLE = "CREATE TABLE orders " +
            "(order_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "orderName TEXT, " +
            "total TEXT, " +
            "address TEXT, " +
            "contact TEXT );";

    private static final String CREATE_INVENTORY_TABLE = "CREATE TABLE inventory " +
            "(inventory_id INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "productName TEXT, " +
            "quantity_available TEXT );";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "Creating database table at: " + db.getPath());
        db.execSQL(CREATE_USER_TABLE);
        db.execSQL(CREATE_PRODUCT_TABLE);
        db.execSQL(CREATE_ORDER_TABLE);
        db.execSQL(CREATE_INVENTORY_TABLE);
        Log.d(TAG, "Database tables created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.d(TAG, "Upgrading database from version " + oldVersion + " to " + newVersion);
        db.execSQL("DROP TABLE IF EXISTS users");
        db.execSQL("DROP TABLE IF EXISTS products");
        db.execSQL("DROP TABLE IF EXISTS orders");
        db.execSQL("DROP TABLE IF EXISTS inventory");
        onCreate(db);
    }

    public List<OrderModel> getAllOrders() {
        List<OrderModel> orderList = new ArrayList<>();
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM orders", null);
        if (cursor.moveToFirst()) {
            do {
                @SuppressLint("Range") OrderModel order = new OrderModel(
                        cursor.getInt(cursor.getColumnIndex("order_id")),
                        cursor.getString(cursor.getColumnIndex("orderName")),
                        cursor.getString(cursor.getColumnIndex("total")),
                        cursor.getString(cursor.getColumnIndex("address")),
                        cursor.getString(cursor.getColumnIndex("contact"))
                );
                orderList.add(order);
            } while (cursor.moveToNext());
        }
        cursor.close();
        return orderList;
    }

}
