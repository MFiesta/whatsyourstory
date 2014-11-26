// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
<<<<<<< HEAD
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.content.SharedPreferences;
import android.widget.ToggleButton;


public class ChooseSkillsActivity extends Activity {

    ToggleButton button1_row1;
    ToggleButton button2_row1;
    ToggleButton button3_row1;
    ToggleButton button1_row2;
    ToggleButton button2_row2;
    ToggleButton button3_row2;
    ToggleButton button1_row3;
    ToggleButton button2_row3;
    ToggleButton button3_row3;

=======
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseSkillsActivity extends Activity {

>>>>>>> master
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_skills);
<<<<<<< HEAD

        button1_row1 = (ToggleButton) findViewById(R.id.button1_row1);
        button2_row1 = (ToggleButton) findViewById(R.id.button2_row1);
        button3_row1 = (ToggleButton) findViewById(R.id.button3_row1);
        button1_row2 = (ToggleButton) findViewById(R.id.button1_row2);
        button2_row2 = (ToggleButton) findViewById(R.id.button2_row2);
        button3_row2 = (ToggleButton) findViewById(R.id.button3_row2);
        button1_row3 = (ToggleButton) findViewById(R.id.button1_row3);
        button2_row3 = (ToggleButton) findViewById(R.id.button2_row3);
        button3_row3 = (ToggleButton) findViewById(R.id.button3_row3);

    }

    public void skillsNext(View view) {
        SharedPreferences sharedPreferences=getSharedPreferences("ChooseSkillsData", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putBoolean("button1_row1", true);
        editor.putBoolean("button2_row1", true);
        editor.putBoolean("button3_row1", true);
        editor.putBoolean("button1_row2", true);
        editor.putBoolean("button2_row2", true);
        editor.putBoolean("button3_row2", true);
        editor.putBoolean("button1_row3", true);
        editor.putBoolean("button2_row3", true);
        editor.putBoolean("button3_row3", true);

        editor.apply();

=======
    }

    public void skillsNext(View view) {
>>>>>>> master
        Intent ChooseSkillsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseSkillsActivity);
    }

}