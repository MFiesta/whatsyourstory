package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * Created by chiahuihsieh on 10/27/14.
 */
public class EditProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_editing);
    }

    public void MyInitProfileNext(View view) {
        Intent SetMyInitProfileActivity = new Intent(this, ChooseSkillsActivity.class);
        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(SetMyInitProfileActivity);
    }
}
