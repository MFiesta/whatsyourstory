package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class LogInActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }
    public void SignUpText(View view){
        Intent SignUpActivity = new Intent(this, SignUpActivity.class);
        startActivity(SignUpActivity);

    }


    public void LogIn(View view) {
        Intent LogInActivity = new Intent(this, FeedActivity.class);
        startActivity(LogInActivity);
    }

    //LogIn if user already has un, password; Takes user to FeedActivity

    public void SignUp(View view){
        Intent SignUpActivity = new Intent(this, SignUpActivity.class);
        startActivity(SignUpActivity);
    }

    //SignUp if user does not already have un, password.  Takes user to SignUpActivity

    }

