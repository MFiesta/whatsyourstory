package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class OtherUserProfileActivity extends Activity {

    List<String> favoriteUsersList = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);

    //this will hopefully populate the Favorites list??

            initList();

            // Get the message from the intent
            Intent intent = getIntent();
            String message = intent.getStringExtra(FavoritesActivity.EXTRA_MESSAGE);

            int id = (int) Long.parseLong(message);

            // Create the text view -- look at Amine's xml to see what textview he is referring to
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText(favoriteUsersList.get(id));

        }

        // initList is a helper method that grabs our "team data" and associates it with the correct id
        // based on its position in the list
        // in a real application, this would be where we query the database and fetch the data associated
        // with the users
        private void initList() {
            favoriteUsersList.add("Eytan Adar");
            favoriteUsersList.add("Mark Newman");
            favoriteUsersList.add("Joyojeet Pal");
            favoriteUsersList.add("Steve Rogers");
            favoriteUsersList.add("Deadpool");
            favoriteUsersList.add("Batman");
            favoriteUsersList.add("Aquaman");
        }

    //clicking on Message button triggers intent to take you to MessageActivity
    public void Message(View view) {
        Intent messageIntent = new Intent(this, MessageActivity.class);
        startActivity(messageIntent);
    }
}