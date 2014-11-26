package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class SignUpActivity extends Activity {

    private EditText username, password;
    public static final String name = "nameKey";
    public static final String pass = "passwordKey";

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText)findViewById(R.id.choose_your_username);
        password = (EditText)findViewById(R.id.choose_your_password);
    }

    public void SignUpNext(View view) {
            //method called onClicking the Next button
            //input username, password, confirm password, email info
        //would concatenate the email with the username and password in real life
        // TODO: dialog box when password inputs do not match up?
        //Note: it shouldn't editor.clear on logout because we don't have a database


        SharedPreferences sharedPreferences=getSharedPreferences("CheckSignUp", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String u = username.getText().toString();
        String p = password.getText().toString();
        editor.putString(name, u); //name is the String key, u aka what the user puts in to the sign up box, is the String Value
        editor.putString(pass, p);
        editor.apply();

        Intent SetProfileActivity = new Intent(this, SetMyInitProfileActivity.class);
        startActivity(SetProfileActivity);
        finish(); //finishes the activity/destroys it
        }
}

//onClick Next button
//verify username, password, confirm password, email info
