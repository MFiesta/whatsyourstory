package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by chiahuihsieh on 10/27/14
 * Modified by Stephanie Wooten 11/14
 * Modified by Michelle Fiesta 11/23
 */
public class MyProfileActivity extends Activity {

    public static final String DEFAULT="N/A";

    TextView fullnameTextView, titleTextView, companyTextView, locationTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);


        fullnameTextView = (TextView) findViewById(R.id.userFullNameSharedPrefs);
        titleTextView = (TextView) findViewById(R.id.userTitleSharedPrefs);
        companyTextView = (TextView) findViewById(R.id.userCompanySharedPrefs);
        locationTextView = (TextView) findViewById(R.id.userLocationSharedPrefs);

        SharedPreferences sharedPreferences=getDefaultSharedPreferences(this);
        String fullname=sharedPreferences.getString("fullname", DEFAULT);
        String title=sharedPreferences.getString("title", DEFAULT);
        String company=sharedPreferences.getString("company", DEFAULT);
        String location=sharedPreferences.getString("location", DEFAULT);

        fullnameTextView.setText(fullname);
        titleTextView.setText(title);
        companyTextView.setText(company);
        locationTextView.setText(location);

    }


    public void EditMyProfileNext (View view) {
        Intent EditMyProfileActivity = new Intent(this, ChooseSkillsActivity.class);
        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(EditMyProfileActivity);
    }

}

