// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.ToggleButton;


public class ChooseSkillsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_skills);
    }

    public void skillsNext(View view) {
        Intent ChooseSkillsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseSkillsActivity);
    }

    private ToggleButton toggle;

    @Override
    public void onClick(View v)
    {
        if (toggle.isChecked())
        {
            SharedPreferences.Editor editor = getSharedPreferences("com.example.si543.whatsyourstory", MODE_PRIVATE).edit();
            editor.putBoolean("NameOfThingToSave", true);
            editor.commit();
        }
        else
        {
            SharedPreferences.Editor editor = getSharedPreferences("com.example.si543.whatsyourstory", MODE_PRIVATE).edit();
            editor.putBoolean("NameOfThingToSave", false);
            editor.commit();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        SharedPreferences sharedPrefs = getSharedPreferences("com.example.si543.whatsyourstory", MODE_PRIVATE);
        toggle.setChecked(sharedPrefs.getBoolean("NameOfThingToSave", true));
    }

    //Takes User to ChooseInterestsActivity after they select which skills they have

}