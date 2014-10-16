package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SignUpActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sign_up);
    }

    public void signupNext (View view) {
        //onClick Next button
        //verify un, password, confirm password, email info
        Intent SetProfileActivity = new Intent(this, SetProfileActivity.class);
        startActivity(SetProfileActivity);
    }
}

