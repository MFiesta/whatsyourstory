// Michelle Fiesta

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;

public class ChooseSkillsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_skills);

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

        ad.setMessage("Are you a master entrepreneur? Do you have a knack for microbrewing? Add those skills here! ");


        ad.setButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();

            }
        });

        ad.show();

    }


    public void skillsNext(View view) {
        Intent ChooseSkillsActivity = new Intent(this, ChooseInterestsActivity.class);
        startActivity(ChooseSkillsActivity);
    }

}