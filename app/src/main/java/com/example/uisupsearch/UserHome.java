package com.example.uisupsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class UserHome extends AppCompatActivity {

    Button AddProducts;
    Button UserProducts;
    Button Search;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_home);

        AddProducts = (Button) findViewById(R.id.YourProducts);
        AddProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(UserHome.this, AddProducts.class);
                startActivity(i);
            }
        });
        UserProducts = (Button) findViewById(R.id.UserProducts);
        UserProducts.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent iS = new Intent(UserHome.this, UserProducts.class);
                startActivity(iS);
            }
        });
        Search = (Button) findViewById(R.id.Search);
        Search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent is = new Intent(UserHome.this, SearchProducts.class);
                startActivity(is);
            }
        });

    }
}
