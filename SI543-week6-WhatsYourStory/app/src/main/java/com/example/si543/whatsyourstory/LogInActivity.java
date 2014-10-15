package com.example.si543.whatsyourstory;
//Alice Rhee
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LogInActivity extends Activity {

@Override
protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

//onClick Log In button
public void LogIn(View view) {
        Intent FeedActivity = new Intent (this, FeedActivity.class);
        startActivity(FeedActivity);
        }
//onClick Sign Up button
public void SignUp(View view) {
        Intent SignUpActivity = new Intent (this, SignUpActivity.class);
        startActivity(SignUpActivity);
        }
}

// include things about user databases - check to see if UN already exists, etc. Pseudocode this.