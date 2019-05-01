package com.example.uisupsearch;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    public DatabaseHelper(Context context) {
        super(context, "UserLogin.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(netID text primary key, password text)");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("drop table if exists user");

    }
    //inserting in database
    public boolean insertD(String netID, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("netID", netID);
        contentValues.put("password", password);
        long ins = db.insert("user", null, contentValues);
        if (ins == -1) {
            return false;
        } else {
            return true;
        }
    }
    //checking if netID exists in database.
    public Boolean check(String netID) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where netID = ?", new String[] {netID});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }
    //checking the netID and password.
    public Boolean check2(String netID, String password) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("Select * from user where netID = ? and password = ?", new String[] {netID, password});
        if (cursor.getCount() > 0) {
            return false;
        } else {
            return true;
        }
    }
}
