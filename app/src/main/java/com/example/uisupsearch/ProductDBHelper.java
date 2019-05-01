package com.example.uisupsearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.NavigableMap;

public class ProductDBHelper extends SQLiteOpenHelper {

    //public static final String TABLE_NAME = "product";
    //public static final String COL2 = "productInfo";

    //public static final String UNIVERSAL_PRODUCTS = "Universal.db";


    public ProductDBHelper(Context context) {
        super(context, "UserProduct.db", null, 1);
    }
    //private static final String create = "CREATE TABLE " + TABLE_NAME + " (" + COL1 + " INTEGER PRIMARY KEY AUTOINCREMENT, " + COL2 + " TEXT " + ")";

    @Override
    public void onCreate(SQLiteDatabase db) {
        //db.execSQL("Create table product(product_id integer primary key autoincrement, product text)");
        db.execSQL("Create table product(productInfo text primary key)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists product");
        onCreate(db);
    }

    public boolean addData(String p) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("productInfo", p);
        //contentValues.put("price", price);
        //contentValues.put("contact", contact);

        long ins = db.insert("product", null, contentValues);
        if (ins == -1) {
            return false;
        } else {
            return true;
        }
    }

    //data does not insert if -1
    public Cursor getList() {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor data = db.rawQuery("Select * from product", null);
        return data;
    }
}
    /**
    public Cursor searchProduct(String text) {
        SQLiteDatabase db = this.getReadableDatabase();
        String query = "Select * from" + TABLE_NAME + "where" + COL2 + "Like'%"+text+"%'";
        Cursor cursor = db.rawQuery(query, null);
        return cursor;
    }
     **/

