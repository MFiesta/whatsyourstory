// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.content.SharedPreferences;
import android.widget.ToggleButton;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;

public class ChooseSkillsActivity extends Activity {

    ToggleButton button1_prog;
    ToggleButton button2_prog;
    ToggleButton button3_prog;
    ToggleButton button4_prog;
    ToggleButton button5_prog;
    ToggleButton button1_des;
    ToggleButton button2_des;
    ToggleButton button3_des;
    ToggleButton button4_des;
    ToggleButton button5_des;
    ToggleButton button1_hob;
    ToggleButton button2_hob;
    ToggleButton button3_hob;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_skills);

        button1_prog = (ToggleButton) findViewById(R.id.button1_prog);
        button2_prog = (ToggleButton) findViewById(R.id.button2_prog);
        button3_prog = (ToggleButton) findViewById(R.id.button3_prog);
        button4_prog = (ToggleButton) findViewById(R.id.button4_prog);
        button5_prog = (ToggleButton) findViewById(R.id.button5_prog);
        button1_des = (ToggleButton) findViewById(R.id.button1_des);
        button2_des = (ToggleButton) findViewById(R.id.button2_des);
        button3_des = (ToggleButton) findViewById(R.id.button3_des);
        button4_des = (ToggleButton) findViewById(R.id.button4_des);
        button5_des = (ToggleButton) findViewById(R.id.button5_des);
        button1_hob = (ToggleButton) findViewById(R.id.button1_hob);
        button2_hob = (ToggleButton) findViewById(R.id.button2_hob);
        button3_hob = (ToggleButton) findViewById(R.id.button3_hob);


        final ChooseSkillsTutorialDialog sampleDialog = new ChooseSkillsTutorialDialog(this, "");
        sampleDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Delay dialog
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                sampleDialog.show();
            }
        }, 400);
    }

    public void skillsNext(View view) {
        {
            if (button1_prog.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Java", "Java, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Java", "");
                editor.apply();
            }
        }
        {
            if (button2_prog.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("C++","C++, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("C++", "");
                editor.apply();
            }
        }
        {
            if (button3_prog.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Python", "Python, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Python", "");
                editor.apply();
            }
        }
        {
            if (button4_prog.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Ruby", "Ruby, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Ruby", "");
                editor.apply();
            }
        }
        {
            if (button5_prog.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Javascript", "Javascript, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Javascript", "");
                editor.apply();
            }
        }
        {
            if (button1_des.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("UX Design", "UX Design, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("UX Design", "");
                editor.apply();
            }
        }
        {
            if (button2_des.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Web Design", "Web Design, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Web Design", "");
                editor.apply();
            }
        }
        {
            if (button3_des.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("HTML", "HTML, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("HTML", "");
                editor.apply();
            }
        }
        {
            if (button4_des.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("CSS", "CSS, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("CSS", "");
                editor.apply();
            }
        }
        {
            if (button5_des.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Illustrator", "Illustrator, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Illustrator", "");
                editor.apply();
            }
        }
        {
            if (button1_hob.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Dance", "Dance, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Dance", "");
                editor.apply();
            }
        }
        {
            if (button2_hob.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Jogging", "Jogging, ");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Jogging", "");
                editor.apply();
            }
        }
        {
            if (button3_des.isChecked()) {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Food", "Food");
                editor.apply();
            } else {
                SharedPreferences sharedPreferences = getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("Food", "");
                editor.apply();
            }
        }
        Intent ChooseSkillsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseSkillsActivity);
    }

}