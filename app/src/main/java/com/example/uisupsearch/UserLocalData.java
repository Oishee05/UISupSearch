package com.example.uisupsearch;

import android.content.Context;
import android.content.SharedPreferences;

public class UserLocalData {
    public static final String UIN = "userDetails";
    SharedPreferences userLocal;

    public UserLocalData(Context cxt) {
        userLocal = cxt.getSharedPreferences(UIN, 0);
    }

    public void store(UserData user) {
        SharedPreferences.Editor ueditor = userLocal.edit();
        ueditor.putString("name", user.name);
        ueditor.putString("netID", user.netID);
        ueditor.putString("password", user.password);
        ueditor.commit();
    }

    public boolean getUserLoggedIn() {
        if (userLocal.getBoolean("loggedIn", false) == true) {
            return true;
        } else {
            return false;
        }
    }

    public UserData getLoggedIn() {
        String name = userLocal.getString("name", "");
        String netID = userLocal.getString("netID", "");
        String password = userLocal.getString("password", "");

        UserData stored = new UserData(name, netID, password);

        return stored;
    }

    public void setLoggedIn(boolean loggedIn) {
        SharedPreferences.Editor ueditor = userLocal.edit();
        ueditor.putBoolean("loggedIn", loggedIn);
        ueditor.commit();
    }

    public void clearData() {
        SharedPreferences.Editor ueditor = userLocal.edit();
        ueditor.clear();
        ueditor.commit();
    }
}
