// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;
import android.widget.ToggleButton;

import static android.preference.PreferenceManager.getDefaultSharedPreferences;


public class ChooseInterestsActivity extends Activity {

    ToggleButton button1_prog_interests;
    ToggleButton button2_prog_interests;
    ToggleButton button3_prog_interests;
    ToggleButton button4_prog_interests;
    ToggleButton button5_prog_interests;
    ToggleButton button1_des_interests;
    ToggleButton button2_des_interests;
    ToggleButton button3_des_interests;
    ToggleButton button4_des_interests;
    ToggleButton button5_des_interests;
    ToggleButton button1_hob_interests;
    ToggleButton button2_hob_interests;
    ToggleButton button3_hob_interests;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_interests);

        button1_prog_interests = (ToggleButton) findViewById(R.id.button1_prog_interests);
        button2_prog_interests = (ToggleButton) findViewById(R.id.button2_prog_interests);
        button3_prog_interests = (ToggleButton) findViewById(R.id.button3_prog_interests);
        button4_prog_interests = (ToggleButton) findViewById(R.id.button4_prog_interests);
        button5_prog_interests = (ToggleButton) findViewById(R.id.button5_prog_interests);
        button1_des_interests = (ToggleButton) findViewById(R.id.button1_des_interests);
        button2_des_interests = (ToggleButton) findViewById(R.id.button2_des_interests);
        button3_des_interests = (ToggleButton) findViewById(R.id.button3_des_interests);
        button4_des_interests = (ToggleButton) findViewById(R.id.button4_des_interests);
        button5_des_interests = (ToggleButton) findViewById(R.id.button5_des_interests);
        button1_hob_interests = (ToggleButton) findViewById(R.id.button1_hob_interests);
        button2_hob_interests = (ToggleButton) findViewById(R.id.button2_hob_interests);
        button3_hob_interests = (ToggleButton) findViewById(R.id.button3_hob_interests);

        final ChooseInterestsTutorialDialog sampleDialog = new ChooseInterestsTutorialDialog(this, "");
        sampleDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        //Delay dialog
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            public void run() {
                sampleDialog.show();
            }
        }, 400);

    }



    public void interestsNext(View view) {
        {
            if (button1_prog_interests.isChecked()) {
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
            if (button2_prog_interests.isChecked()) {
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
            if (button3_prog_interests.isChecked()) {
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
            if (button4_prog_interests.isChecked()) {
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
            if (button5_prog_interests.isChecked()) {
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
            if (button1_des_interests.isChecked()) {
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
            if (button2_des_interests.isChecked()) {
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
            if (button3_des_interests.isChecked()) {
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
            if (button4_des_interests.isChecked()) {
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
            if (button5_des_interests.isChecked()) {
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
            if (button1_hob_interests.isChecked()) {
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
            if (button2_hob_interests.isChecked()) {
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
            if (button3_des_interests.isChecked()) {
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

        Intent ChooseInterestsActivity = new Intent(this, HomeActivity.class);
        startActivity(ChooseInterestsActivity);
    }

    //Takes user to HomeActivity after they select their Interests
}