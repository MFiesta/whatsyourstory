package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

//Stephanie Wooten
//Michelle Fiesta added SharedPreferences stuff

public class SetMyInitProfileActivity extends Activity {

    //Full name, title, company, location edittext
    EditText edit_full_name, edit_current_title, edit_current_company, edit_current_location;

    //Session Manager class
    SessionManagement session;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_init_profile_settings);

        //Session Manager
        session = new SessionManagement(getApplicationContext());

        //Full name, title, company, location input text
        edit_full_name = (EditText) findViewById(R.id.edit_full_name);
        edit_current_title = (EditText) findViewById(R.id.edit_current_title);
        edit_current_company = (EditText) findViewById(R.id.edit_current_company);
        edit_current_location = (EditText) findViewById(R.id.edit_current_location);
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