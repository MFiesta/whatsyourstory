package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//Stephanie Wooten


public class SetProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_settings);
    }

    public void setUp(View view) {
        Intent intent = new Intent(this, FeedView.class);
        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(intent);
    }


}