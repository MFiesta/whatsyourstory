package com.example.si543.whatsyourstory;

/**
 * Created by alicerhee on 10/25/14. Following Teamivore code
 * Updated by Stephanie on 11/24 - Add SharedPrefs
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoritesActivity extends Activity {

        // the string variable we use for sending messages with intents - no idea what this means yet
        public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

        // a list class type must be used when using a list view
        // list items are added to a list view programatically and not through xml
        List<Map<String, String>> favList = new ArrayList<Map<String,String>>();

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_favorites);

            // we call this initList function to fill in our list class variable with our team names
            initList();

            // adapters are what we use to associate the list variable and its contents with the list view
            ListView favoriteUsersListView = (ListView) findViewById(R.id.favoritesListView);
            //update the XML files referenced below
            SimpleAdapter simpleAdpt = new SimpleAdapter(this, favList, android.R.layout.simple_list_item_1, new String[] {"favorites"}, new int[] {android.R.id.text1});
            favoriteUsersListView.setAdapter(simpleAdpt);

            // setOnItemClickListener tells the activity what to do when a list item is clicked on
            favoriteUsersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

                public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                        long id) {
                    openFavoriteUserDetail(id);
                }
            });

        }
    // openTeamDetail is called whenever a list item is clicked on
    // it calls for an intent that starts up the team detail activity and sends the team's id over
    // to the activity with the message variable declared at the top of the activity

    //Alice says: how to figure out a way to make this a parameter so it all just doesn't go to Eytan?
    public void openFavoriteUserDetail(long id) {
        Intent intent = new Intent(this, OtherUserProfileActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
        // initList simply adds our favorites to the list
        private void initList() {

            //gets the favorite list to add new favorite
            List<FavoriteUserData> favorites = SharedPreferencesUtility.getFavoriteList(this, "favorites");

            for(FavoriteUserData f: favorites) {

                String name = f.getName();

                favList.add(createFav("favorites", name));
            }
        }

        // this method helps us minimize the amount of repeat calls we need to make in initList to place
        // a team name into out list. I (Alice) am keeping the variable 'team' for convenience.
        private HashMap<String, String> createFav(String key, String name) {
            HashMap<String, String> fav = new HashMap<String, String>();
            fav.put(key, name);
            return fav;
        }

    }