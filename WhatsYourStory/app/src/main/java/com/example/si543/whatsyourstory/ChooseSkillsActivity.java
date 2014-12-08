// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;

public class ChooseSkillsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_skills);

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
        Intent ChooseSkillsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseSkillsActivity);
    }

}