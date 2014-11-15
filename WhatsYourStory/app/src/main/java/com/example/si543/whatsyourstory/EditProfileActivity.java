package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/14/14.
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class EditProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            EditProfileFragment fragment = new EditProfileFragment();
            getFragmentManager().beginTransaction()
                    .add(R.id.frame_container, fragment)
                    .commit();
        }
    }

    public void EditMyProfileNext (View view) {
        Intent EditMyProfileActivity = new Intent(this, ChooseSkillsActivity.class);
        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(EditMyProfileActivity);
    }

}
