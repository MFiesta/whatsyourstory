package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.view.View;

/**
 * Created by akimaru on 10/15/14.
 */

public class LogInActivity extends Activity {
//onClick Log In button
public void LogIn (View view) {
        Intent FeedActivity = new Intent (this, FeedActivity.class);
        startActivity(FeedActivity);
        }
//onClick Sign Up button
public void SignUp (View view) {
        Intent SignUpActivity = new Intent (this, SignUpActivity.class);
        startActivity(SignUpActivity);
        }
}

// include things about user databases - check to see if UN already exists, etc. Pseudocode this.