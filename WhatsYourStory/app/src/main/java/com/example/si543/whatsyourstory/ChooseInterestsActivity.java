// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;


public class ChooseInterestsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_interests);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable(){
            @Override
            public void run(){
                showAlert();
            }
        }, 500);

    }

    public void showAlert () {
        AlertDialog ad = new AlertDialog.Builder(this).create();
        //LayoutInflater inflater = this.getLayoutInflater();
        //ad.setView(inflater.inflate(R.layout.dialog_signup_layout, null));
        ad.setCancelable(false); // This blocks the 'BACK' button

        ad.setMessage("What kind of stories are you interested in hearing about? Stories about pursuing specific career path? Living the foodie life? Select some interests here!");


        ad.setButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();

            }
        });

        ad.show();

    }


    public void interestsNext(View view) {
        Intent ChooseInterestsActivity = new Intent(this, FeedActivity.class);
        startActivity(ChooseInterestsActivity);
    }

    //Takes user to FeedActivity after they select their Interests
}