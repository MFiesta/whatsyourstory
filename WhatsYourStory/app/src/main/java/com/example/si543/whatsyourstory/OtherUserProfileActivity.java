package com.example.si543.whatsyourstory;

//Alice Rhee & Stephanie Wooten (addFavorite and Message methods)

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class OtherUserProfileActivity extends Activity {


    // the string variable we use for sending messages with intents - no idea what this means yet
    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

    ArrayList<FeedUserData> values = new ArrayList<FeedUserData>();

    int id;

    // Alert Dialog Manager
    AlertDialogManager msgAlert = new AlertDialogManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);

        initList();

        Intent intent = getIntent();
        String message = intent.getStringExtra(FeedFragment.EXTRA_MESSAGE);

        id = (int) Long.parseLong(message);

        // Create the text view

        ImageView imageViewUserPicture = (ImageView) findViewById(R.id.userPicture);
        String imagePath = values.get(id).getImagePath();

        if (imagePath != null) {

            try {
                imageViewUserPicture.setImageBitmap(BitmapFactory.decodeStream(getAssets().open(imagePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        TextView textViewName = (TextView) findViewById(R.id.textView_OtherUserName);
        textViewName.setText(values.get(id).getName());


        TextView textViewCareer = (TextView) findViewById(R.id.textView_OtherUserCareer);
        textViewCareer.setText(values.get(id).getCareer());

        TextView textViewLocation = (TextView) findViewById(R.id.textView_OtherUserLocation);
        textViewLocation.setText(values.get(id).getLocation());
    }

//Message Intent 
   public void Message (View view){

       msgAlert.showAlertDialog(OtherUserProfileActivity.this, "This will take you outside of this app to your default texting app.", "Is that okay?", true);
       //calls sms messaging on phone
       Intent sendIntent = new Intent(Intent.ACTION_VIEW);
       sendIntent.putExtra("address", "555-555-5555");
       sendIntent.setType("vnd.android-dir/mms-sms");
       startActivity(sendIntent);

    }

    //Adds profile to favorites list
    public void addFavorite(View view) {

        // get favorites list from SharedPreferences

        List<Integer> favorites = SharedPreferencesUtility.getFavoriteList(this, "favorites");

        //checks to see if favorite is already in user's favorites list
        if(favorites.contains(id)){
            Toast.makeText(getApplicationContext(), "This member is already in your favorites!",
                    Toast.LENGTH_LONG).show();
        }else {

            //add id from the specific user profile to the favorites list

            favorites.add(id);

            // toast message long

            Toast.makeText(getApplicationContext(), "This member has been added to your favorites!",
                    Toast.LENGTH_LONG).show();
        }

        SharedPreferencesUtility.putFavoriteList(this, "favorites", favorites);

    }

    //Add item to adapter
    private void initList() {
        FeedUserData user = new FeedUserData("Eytan Adar", "Associate Professor at University of Michigan", "Ann Arbor", "adar_eytan.png");
        values.add(user);
        user = new FeedUserData("Alexis Peterka", "Senior UX Designer at CrowdCompass", "Ann Arbor", "alexis.png");
        values.add(user);
        user = new FeedUserData("Min-Chih (Tiffany) Liu", "Product Designer at Citrix", "San Francisco Bay Area", "tiffany_liu.png");
        values.add(user);
        user = new FeedUserData("Dimitriosyutaka Akimaru", "Founder at Sophus", "San Francisco, California", "dimitri.png");
        values.add(user);
        user = new FeedUserData("Ying Ying Liu", "User Experience Designer at YouTube", "San Francisco Bay Area", "ying_ying.png");
        values.add(user);
        user = new FeedUserData("Kevin Steigerwald", "Freelance Product Designer for Sproutworx, LLC", "San Francisco, Californiar", "kevin.png");
        values.add(user);
        user = new FeedUserData("Kelly Kowatch", "Program Manager, Service Engagement at University of Michigan", "Ann Arbor", "kelly_kowatch.png");
        values.add(user);

    }

//Action Bar
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.other_user_profile, menu);
        return true;
    }

    }

