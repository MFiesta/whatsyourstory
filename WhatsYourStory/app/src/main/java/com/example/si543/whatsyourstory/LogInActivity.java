package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
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




    public void LogIn(View view) {
        Intent LogInActivity = new Intent(this, FeedActivity.class);
        startActivity(LogInActivity);
    }

    public void SignUp(View view){
        Intent SignUpActivity = new Intent(this, SignUpActivity.class);
        startActivity(SignUpActivity);
    }

    }

