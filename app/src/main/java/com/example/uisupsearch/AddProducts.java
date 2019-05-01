package com.example.uisupsearch;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class AddProducts extends AppCompatActivity {
    EditText addProduct;
    Button AddButton, ViewButton;
    ProductDBHelper dbHelper;

    ListView userList;
    ArrayList<String> ListItem;
    ArrayAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_products);

        dbHelper = new ProductDBHelper(this);

        addProduct = (EditText) findViewById(R.id.addProduct);
        AddButton = (Button) findViewById(R.id.AddButton);
        ViewButton = (Button) findViewById(R.id.ViewButton);

        ViewButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AddProducts.this, UserProducts.class);
                startActivity(intent);
                }
            });
        AddButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String newEntry = addProduct.getText().toString();
                if (newEntry.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty!", Toast.LENGTH_LONG).show();
                } else if (dbHelper.addData(newEntry) == true){
                    Toast.makeText(getApplicationContext(), "Product Added, hoorah!", Toast.LENGTH_SHORT).show();
                    addProduct.setText("");
                }
            }
        });
        /**ListItem = new ArrayList<>();
        userList = findViewById(R.id.userslist);
        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                String text = userList.getItemAtPosition(position).toString();
                Toast.makeText(AddProducts.this, "" + text, Toast.LENGTH_SHORT).show();
            }
        });

        Cursor cursor = dbHelper.getList();
        if (cursor.getCount() == 0) {
            Toast.makeText(getApplicationContext(), "No products :( YET", Toast.LENGTH_SHORT).show();
        } else {
            while(cursor.moveToNext()) {
                ListItem.add(cursor.getString(0));
                //Toast.makeText(getApplicationContext(), "Product:" + cursor.getString(0), Toast.LENGTH_SHORT).show();

            }
            adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ListItem);
            userList.setAdapter(adapter);
        }
         **/
    }
    public void AddData(String newEntry) {
        Boolean insertData = dbHelper.addData(newEntry);

        if (insertData == true) {
            Toast.makeText(getApplicationContext(), "Successfully entered data!", Toast.LENGTH_LONG).show();
        } else {
            Toast.makeText(getApplicationContext(), "Oops something went wrong!", Toast.LENGTH_LONG).show();
        }

    }
}