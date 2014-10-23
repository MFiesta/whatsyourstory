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
        setContentView(R.layout.activity_choose_skills);
    }

    public void SkillsNext(View view) {
        Intent ChooseSkillsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseSkillsActivity);
    }
}
