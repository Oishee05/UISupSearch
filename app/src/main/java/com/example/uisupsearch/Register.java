package com.example.uisupsearch;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Register extends AppCompatActivity  {

    DatabaseHelper db;
    Button RegisterButton, AlreadyButton;
    EditText checkPassword, enterNetID, enterPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        db = new DatabaseHelper(this);
        enterNetID = (EditText) findViewById(R.id.enterNetID);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        checkPassword = (EditText) findViewById(R.id.checkPassword);
        RegisterButton = (Button) findViewById(R.id.RegisterButton);
        AlreadyButton = (Button) findViewById(R.id.AlreadyButton);
        AlreadyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Register.this, UserLogin.class);
                startActivity(i);
            }
        });
        RegisterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String net = enterNetID.getText().toString();
                String pwd = enterPassword.getText().toString();
                String chkpwd = checkPassword.getText().toString();
                if (net.equals("") || pwd.equals("") || chkpwd.equals("")) {
                    Toast.makeText(getApplicationContext(), "Fields are empty", Toast.LENGTH_SHORT).show();
                } else {
                    if (pwd.equals(chkpwd)) {
                        Boolean check3 = db.check(net);
                        if (check3 == true) {
                            Boolean insert = db.insertD(net, pwd);
                            if (insert == true) {
                                Toast.makeText(getApplicationContext(), "Success!", Toast.LENGTH_SHORT).show();
                                Intent i = new Intent(Register.this, UserHome.class);
                                startActivity(i);
                            }
                        } else {
                            Toast.makeText(getApplicationContext(), "NetID already exists", Toast.LENGTH_SHORT).show();
                        }
                    } else if (!pwd.equals(chkpwd)) {
                        Toast.makeText(getApplicationContext(), "Password does not match :(",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
    /**
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.RegisterButton:
                    String name = enterName.getText().toString();
                    String netID = enterNetID.getText().toString();
                String pwd = enterPassword.getText().toString();

                UserData registeredUser = new UserData(name, netID, pwd);

                registerUser(registeredUser);
                break;
        }
    }
    public void registerUser(UserData userData) {
        ServerRequest serverRequest = new ServerRequest(this);
        serverRequest.storeUserDataInBackground(userData, new GetUserCallBack() {
            @Override
            public void done(UserData returnedUser) {
                startActivity(new Intent(Register.this, Login.class));
            }
        });
    }
}

**/