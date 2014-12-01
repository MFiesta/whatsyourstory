package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.preference.PreferenceManager;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

//Stephanie Wooten
//Michelle Fiesta - SharedPreferences functionality 11/23

public class SetMyInitProfileActivity extends Activity {

    //Full name, title, company, location EditText
    EditText edit_full_name;
    EditText edit_current_title;
    EditText edit_current_company;
    EditText edit_current_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_init_profile_settings);

        //Full name, title, company, location input text
        edit_full_name = (EditText) findViewById(R.id.edit_full_name);
        edit_current_title = (EditText) findViewById(R.id.edit_current_title);
        edit_current_company = (EditText) findViewById(R.id.edit_current_company);
        edit_current_location = (EditText) findViewById(R.id.edit_current_location);
    }

    public void MyInitProfileNext(View view) {
        //Putting SharedPreferences for full name, title, company, and location
        SharedPreferences sharedPreferences=getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("fullname", edit_full_name.getText().toString());
        editor.putString("title", edit_current_title.getText().toString());
        editor.putString("company", edit_current_company.getText().toString());
        editor.putString("location", edit_current_location.getText().toString());

        //Committing SharedPreferences
        editor.apply();

        Intent SetMyInitProfileActivity = new Intent(this, ChooseSkillsActivity.class);

        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(SetMyInitProfileActivity);

        /**
         * Finishes the activity, destroys it, takes user to ChooseSkillsActivity to continue
         * filling out profile
         */

    }
}