package com.example.uisupsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UserLogin extends AppCompatActivity {
    EditText enterNetID, enterPassword;
    Button Loginbutton;
    DatabaseHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_login);

        db = new DatabaseHelper(this);
        enterNetID = (EditText)findViewById(R.id.enterNetID);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        Loginbutton = (Button) findViewById(R.id.Loginbutton);
        Loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String netID = enterNetID.getText().toString();
                String pwd = enterPassword.getText().toString();
                Boolean c = db.check2(netID, pwd);
                if (c == true && !(netID.equals("") || pwd.equals(""))) {
                    Toast.makeText(getApplicationContext(), "Successful!", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(UserLogin.this, UserHome.class);
                    startActivity(i);
                } else {
                    Toast.makeText(getApplicationContext(), "Incorrect Info", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
