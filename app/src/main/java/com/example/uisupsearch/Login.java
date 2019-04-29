package com.example.uisupsearch;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Login extends AppCompatActivity implements View.OnClickListener {

    Button LoginButton;
    EditText enterNetID, enterPassword;
    TextView linkRegister;

    UserLocalData userLocalData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        enterNetID = (EditText) findViewById(R.id.enterNetID);
        enterPassword = (EditText) findViewById(R.id.enterPassword);
        linkRegister = (TextView) findViewById(R.id.linkRegister);
        LoginButton.setOnClickListener(this);
        linkRegister.setOnClickListener(this);

        userLocalData = new UserLocalData(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.LoginButton:
                String netID = enterNetID.getText().toString();
                String password = enterPassword.getText().toString();

                UserData userData = new UserData(netID, password);

                authenticate(userData);

                UserData user = new UserData(null, null);
                userLocalData.store(user);
                userLocalData.setLoggedIn(true);

                break;

            case R.id.linkRegister:
                startActivity(new Intent(this, Register.class));
                break;
        }
    }

    private void authenticate(UserData userData) {
        ServerRequest serverRequest = new ServerRequest(this);
        serverRequest.fetchUserDataInBackground(userData, new GetUserCallBack() {
            @Override
            public void done(UserData returnedUser) {
                if (returnedUser == null) {
                    showErrorMessage();
                } else {
                    logUserIn(returnedUser);
                }
            }
        });
    }

    private void showErrorMessage() {
        AlertDialog.Builder builder = new AlertDialog.Builder(Login.this);
        builder.setMessage("Incorrect user details");
        builder.setPositiveButton("Okay", null);
        builder.show();
    }

    private void logUserIn(UserData returnedUser) {
        userLocalData.store(returnedUser);
        userLocalData.setLoggedIn(true);

        startActivity(new Intent(this, Home.class));
    }
}
