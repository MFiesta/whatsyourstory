// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ChooseSkillsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_interests);
    }

    public void selectSkills(View view) {
        Intent ChooseInterestsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseInterestsActivity);
    }
}
