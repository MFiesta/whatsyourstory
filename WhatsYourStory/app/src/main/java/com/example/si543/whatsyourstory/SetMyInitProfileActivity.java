package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.InputStream;

//Stephanie Wooten
//Michelle Fiesta - SharedPreferences functionality 11/23

public class SetMyInitProfileActivity extends Activity {

    private final int SELECT_PHOTO = 1;
    private ImageView imageView;

    //Full name, title, company, location EditText
    EditText edit_full_name;
    EditText edit_current_title;
    EditText edit_current_company;
    EditText edit_current_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_init_profile_settings);

        //Full name, title, company, location input text
        edit_full_name = (EditText) findViewById(R.id.edit_full_name);
        edit_current_title = (EditText) findViewById(R.id.edit_current_title);
        edit_current_company = (EditText) findViewById(R.id.edit_current_company);
        edit_current_location = (EditText) findViewById(R.id.edit_current_location);

        imageView = (ImageView)findViewById(R.id.default_picture);

        TextView EditPicture = (TextView) findViewById(R.id.edit_picture);
        EditPicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
                photoPickerIntent.setType("image/*");
                startActivityForResult(photoPickerIntent, SELECT_PHOTO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent imageReturnedIntent) {
        super.onActivityResult(requestCode, resultCode, imageReturnedIntent);

        switch(requestCode) {
            case SELECT_PHOTO:
                if(resultCode == RESULT_OK){
                    try {
                        final Uri imageUri = imageReturnedIntent.getData();
                        final InputStream imageStream = getContentResolver().openInputStream(imageUri);
                        final Bitmap selectedImage = BitmapFactory.decodeStream(imageStream);
                        imageView.setImageBitmap(selectedImage);
                    } catch (FileNotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(getApplicationContext(), "Image capture failed",
                                Toast.LENGTH_SHORT).show();
                    }

                }
        }

    }

    public void MyInitProfileNext(View view) {
        //Putting SharedPreferences for full name, title, company, and location
        SharedPreferences sharedPreferences=getSharedPreferences("ProfActData", Context.MODE_MULTI_PROCESS);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("fullname", edit_full_name.getText().toString());
        editor.putString("title", edit_current_title.getText().toString());
        editor.putString("company", edit_current_company.getText().toString());
        editor.putString("location", edit_current_location.getText().toString());

        //Committing SharedPreferences
        editor.apply();

        Intent SetMyInitProfileActivity = new Intent(this, ChooseSkillsActivity.class);

        //Read Name, Title, Corporation, and Location to verify when "Next" button is clicked
        startActivity(SetMyInitProfileActivity);

        /**
         * Finishes the activity, destroys it, takes user to ChooseSkillsActivity to continue
         * filling out profile
         */

    }

}