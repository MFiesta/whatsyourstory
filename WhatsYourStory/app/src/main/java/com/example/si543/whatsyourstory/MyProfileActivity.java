package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;


/**
 * Created by chiahuihsieh on 10/27/14. - Modified by Stephanie Wooten 11/14
 */
public class MyProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_profile);
    }

    public void EditMyProfileNext (View view) {
        Intent EditMyProfileActivity = new Intent(this, ChooseSkillsActivity.class);
        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(EditMyProfileActivity);
    }

}

