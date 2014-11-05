// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.ToggleButton;


public class ChooseSkillsActivity extends Activity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_skills);
        SharedPreferences sharedPrefs = getSharedPreferences("com.example.si543.whatsyourstory", MODE_PRIVATE);
        toggle.setChecked(sharedPrefs.getBoolean("NameOfThingToSave", true));
    }

    public void skillsNext(View view) {
        Intent ChooseSkillsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseSkillsActivity);
    }

    private ToggleButton toggle;

    public void onClick(View v)
    {
        if (toggle.isChecked())
        {
            SharedPreferences.Editor editor = getSharedPreferences("com.example.si543.whatsyourstory", MODE_PRIVATE).edit();
            editor.putBoolean("Checked", true);
            editor.commit();
        }
        else
        {
            SharedPreferences.Editor editor = getSharedPreferences("com.example.si543.whatsyourstory", MODE_PRIVATE).edit();
            editor.putBoolean("Unchecked", false);
            editor.commit();
        }
    }

    //Takes User to ChooseInterestsActivity after they select which skills they have

}