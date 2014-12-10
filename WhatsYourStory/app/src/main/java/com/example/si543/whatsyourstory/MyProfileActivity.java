package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by chiahuihsieh on 10/27/14
 * Modified by Stephanie Wooten 11/14 - changed to DefaultSharedPreferences
 * Modified by Michelle Fiesta 11/23
 */
public class MyProfileActivity extends Activity {

    TextView fullnameTextView, titleTextView, companyTextView, locationTextView, userSkillsTextView, userInterestsTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);

        fullnameTextView = (TextView) findViewById(R.id.userFullNameSharedPrefs);
        titleTextView = (TextView) findViewById(R.id.userTitleSharedPrefs);
        companyTextView = (TextView) findViewById(R.id.userCompanySharedPrefs);
        locationTextView = (TextView) findViewById(R.id.userLocationSharedPrefs);
        userSkillsTextView = (TextView) findViewById(R.id.userSkillsSharedPrefs);
        userInterestsTextView = (TextView) findViewById(R.id.userInterestsSharedPrefs);

        SharedPreferences sharedPreferences=getDefaultSharedPreferences(this);
        String fullname=sharedPreferences.getString("fullname", null);
        String title=sharedPreferences.getString("title", null);
        String company=sharedPreferences.getString("company", null);
        String location=sharedPreferences.getString("location", null);
        String skills=sharedPreferences.getString("Java", null) + sharedPreferences.getString("C++", null) + sharedPreferences.getString("Python", null) + sharedPreferences.getString("Ruby", null) + sharedPreferences.getString("Javascript", null) + sharedPreferences.getString("UX Design", null) + sharedPreferences.getString("Web Design", null) + sharedPreferences.getString("HTML", null) + sharedPreferences.getString("CSS", null) + sharedPreferences.getString("Illustrator", null) + sharedPreferences.getString("Dance", null) + sharedPreferences.getString("Jogging", null) + sharedPreferences.getString("Food", null);
        String interests=sharedPreferences.getString("Java", null) + sharedPreferences.getString("C++", null) + sharedPreferences.getString("Python", null) + sharedPreferences.getString("Ruby", null) + sharedPreferences.getString("Javascript", null) + sharedPreferences.getString("UX Design", null) + sharedPreferences.getString("Web Design", null) + sharedPreferences.getString("HTML", null) + sharedPreferences.getString("CSS", null) + sharedPreferences.getString("Illustrator", null) + sharedPreferences.getString("Dance", null) + sharedPreferences.getString("Jogging", null) + sharedPreferences.getString("Food", null);

        fullnameTextView.setText(fullname);
        titleTextView.setText(title);
        companyTextView.setText(company);
        locationTextView.setText(location);
        userSkillsTextView.setText(skills);
        userInterestsTextView.setText(interests);

    }


}

