package com.example.uisupsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;

public class AddProducts extends AppCompatActivity {
    EditText addProduct;
    Button AddButton, ViewButton;
    ProductDBHelper dbHelper;


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
                if (addProduct.length() != 0) {
                    AddData(newEntry);
                    addProduct.setText("");
                } else {
                    Toast.makeText(AddProducts.this, "Fields are empty!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public void AddData(String newEntry) {
        Boolean insertData = dbHelper.insert(newEntry);

        if (insertData == true) {
            Toast.makeText(AddProducts.this, "Successfully entered data!", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(AddProducts.this, "Oops something went wrong!", Toast.LENGTH_SHORT).show();
        }

    }
}