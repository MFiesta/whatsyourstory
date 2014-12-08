// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.Window;


public class ChooseInterestsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_interests);

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
        Intent ChooseInterestsActivity = new Intent(this, FeedActivity.class);
        startActivity(ChooseInterestsActivity);
    }

    //Takes user to FeedActivity after they select their Interests
}