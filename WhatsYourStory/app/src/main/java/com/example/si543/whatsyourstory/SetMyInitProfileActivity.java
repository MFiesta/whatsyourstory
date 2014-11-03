package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

//Stephanie Wooten


public class SetMyInitProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_init_profile_settings);
    }

    public void MyInitProfileNext(View view) {
        Intent SetMyInitProfileActivity = new Intent(this, ChooseSkillsActivity.class);
        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(SetMyInitProfileActivity);

        /**
         * Finishes the activity, destroys it, takes user to ChooseSkillsActivity to continue
         * filling out profile
         */

    }
}