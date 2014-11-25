package com.example.si543.whatsyourstory;

//Alice Rhee with modifications by Stephanie Wooten

import android.app.Activity;
import android.content.Context;
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

    private static final String IS_LOGGEDIN = "IsLoggedIn";

    // User name (make variable public to access from outside)
    public static final String username = "username";

    // Email address (make variable public to access from outside)
    public static final String password = "password";

    // Email, password edittext
    EditText usernameinput, passwordinput;

    // login button
    Button email_log_in_button;

  // Alert Dialog Manager
    AlertDialogManager alert = new AlertDialogManager();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Email, Password input text
        usernameinput = (EditText) findViewById(R.id.username);
        passwordinput = (EditText) findViewById(R.id.password);

        email_log_in_button = (Button) findViewById(R.id.email_log_in_button);
        email_log_in_button.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                String username = usernameinput.getText().toString();
                String password = passwordinput.getText().toString();

                // Check if username, password is filled
                if(username.trim().length() > 0 && password.trim().length() > 0){

                    if(username.equals("test") && password.equals("test")){

                        //TODO: Figure out how to make this check info from local SharedPrefs from Sign Up

                        // Starting the next Activity
                        Intent i = new Intent(getApplicationContext(), FeedActivity.class);
                        startActivity(i);

                        SharedPreferences sharedPreferences=getSharedPreferences("CheckLogin", Context.MODE_MULTI_PROCESS);
                        SharedPreferences.Editor editor=sharedPreferences.edit();

                        editor.putBoolean(IS_LOGGEDIN, true);
                        editor.apply();

                        finish();

                    }
                    else{
                        // username / password doesn't match
                        alert.showAlertDialog(LogInActivity.this, "Login failed..", "Username/Password is incorrect", false);
                    }
                }
                else{
                    // user didn't entered username or password
                    // Show alert asking him to enter the details

                    alert.showAlertDialog(LogInActivity.this, "Login failed..", "Please enter username and password", false);
                }

            }
        });
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

