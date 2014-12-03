package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.EditText;


public class SignUpActivity extends Activity {

    private EditText username, password;
    public static final String name = "nameKey";
    public static final String pass = "passwordKey";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        username = (EditText)findViewById(R.id.choose_your_username);
        password = (EditText)findViewById(R.id.choose_your_password);


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
        ad.setTitle("We’re glad you’re joining us.");
        ad.setMessage("Find people whose stories and experiences interest you, and connect with them through the app");


        ad.setButton("OK", new DialogInterface.OnClickListener() {

            public void onClick(DialogInterface dialog, int id) {
                dialog.dismiss();

            }
        });

        ad.show();

    }

    public void SignUpNext(View view) {
            //method called onClicking the Next button
            //input username, password, confirm password, email info
        //would concatenate the email with the username and password in real life
        // TODO: dialog box when password inputs do not match up?
        //Note: it shouldn't editor.clear on logout because we don't have a database


        SharedPreferences sharedPreferences=getSharedPreferences("CheckSignUp", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        String u = username.getText().toString();
        String p = password.getText().toString();
        editor.putString(name, u); //name is the String key, u aka what the user puts in to the sign up box, is the String Value
        editor.putString(pass, p);
        editor.apply();

        Intent SetProfileActivity = new Intent(this, SetMyInitProfileActivity.class);
        startActivity(SetProfileActivity);
        finish(); //finishes the activity/destroys it
        }
}

//onClick Next button
//verify username, password, confirm password, email info
