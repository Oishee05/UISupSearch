package com.example.uisupsearch;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class UserProducts extends AppCompatActivity {

    ProductDBHelper databaseHelper;

    ListView userList;

    ArrayList<String> ListItem;
    ArrayAdapter adapter;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_products);
        databaseHelper = new ProductDBHelper(this);

        ListItem = new ArrayList<>();
        userList = findViewById(R.id.userslist);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String text = userList.getItemAtPosition(position).toString();
                Toast.makeText(UserProducts.this, "" + text, Toast.LENGTH_SHORT).show();
            }
        });

        Cursor cursor = databaseHelper.getList();

        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No products :( YET", Toast.LENGTH_SHORT).show();
        } else {
            while (cursor.moveToNext()) {
                ListItem.add(cursor.getString(0));
                //Toast.makeText(getApplicationContext(), "Product:" + cursor.getString(0), Toast.LENGTH_SHORT).show();

            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListItem);
            userList.setAdapter(adapter);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);

        MenuItem searchItem = menu.findItem(R.id.item_search);
        SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchItem);

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                ArrayList<String> ul = new ArrayList<>();
                for (String user : ListItem) {
                    if (user.toLowerCase().contains(newText.toLowerCase())) {
                        ul.add(user);
                    }
                }
                ArrayAdapter<String> adapter = new ArrayAdapter<String>(UserProducts.this, android.R.layout.simple_list_item_1, ul);
                userList.setAdapter(adapter);
                return true;
            }
        });
        return super.onCreateOptionsMenu(menu);
    }

}

    /**@Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_products);

        ListView listView = (ListView) findViewById(R.id.userslist);
        databaseHelper = new ProductDBHelper(this);

        ArrayList<String> theList = new ArrayList<>();
        Cursor data = databaseHelper.getList();

        if(data.getCount() == 0) {
            Toast.makeText(UserProducts.this, "The entered data was empty", Toast.LENGTH_LONG).show();
        } else {
            while (data.moveToNext()) {
                theList.add(data.getString(1));
                ListAdapter listAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,theList);
                listView.setAdapter(listAdapter);
            }
        }
    }
    **/

