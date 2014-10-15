package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

//Stephanie Wooten


public class SetProfileActivity extends Activity {

    public void setUp(View view) {
        Intent intent = new Intent(this, FeedActivity.class);
        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(intent);
    }


}