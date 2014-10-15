package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
//Chia Hui
public class FeedActivity extends Activity {
    public void hamburger() {

    }

    public void clickProfile (View view) {
        Intent UserProfileActivity = new Intent(this, UserProfileActivity.class);
        startActivity(UserProfileActivity);
    }
}


