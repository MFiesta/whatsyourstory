package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends Activity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

    public void SignUpNext (View view) {
        Intent SetProfileActivity = new Intent(this, SetProfileActivity.class);
        startActivity(SetProfileActivity);
        finish(); //finishes the activity/destroys it?
    }
}

//onClick Next button
//verify un, password, confirm password, email info