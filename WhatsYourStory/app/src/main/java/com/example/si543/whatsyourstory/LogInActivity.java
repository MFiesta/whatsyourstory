package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;

public class LogInActivity extends Activity {

    // Email, password edittext
    EditText username, password;

    // login button
    Button email_log_in_button;

    // Session Management Class
    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Session Management
        session = new SessionManagement(getApplicationContext());

        // Email, Password input text
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);

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

