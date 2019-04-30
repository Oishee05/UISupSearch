package com.example.uisupsearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductDBHelper extends SQLiteOpenHelper {


    public ProductDBHelper(Context context) {
        super(context, "UserProducts", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table product(product_id text primary key, product text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists product");
    }
    public boolean insert(String title) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("product", title);
        //contentValues.put("price", price);
        //contentValues.put("description", description);
        long ins = db.insert("product", null, contentValues);
        if (ins == -1) {
            return false;
        } else {
            return true;
        }
    }
    public Cursor viewProduct() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor data = db.rawQuery("Select * from product", null);

        return data;
    }
}
