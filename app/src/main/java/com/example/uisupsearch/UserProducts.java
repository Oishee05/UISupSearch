package com.example.uisupsearch;


import android.database.Cursor;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserProducts extends AppCompatActivity {

    ProductDBHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_products);

        ListView listView = (ListView) findViewById(R.id.userslist);
        databaseHelper = new ProductDBHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = databaseHelper.viewProduct();

        if(data.getCount() == 0) {
            Toast.makeText(UserProducts.this, "The entered data was empty", Toast.LENGTH_SHORT).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(0));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
}
