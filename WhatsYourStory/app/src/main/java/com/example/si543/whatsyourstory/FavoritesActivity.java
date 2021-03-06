package com.example.si543.whatsyourstory;

/**
 * Created by alicerhee on 10/25/14. Following Teamivore code
 * Updated by Stephanie (with help from Alice) on 11/24 - Add SharedPrefs
 */

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FavoritesActivity extends Activity {

    // the string variable we use for sending messages with intents - no idea what this means yet
    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

    // a list class for the actual list of favorites pulled from the SharedPreferences Utility
    List<Map<String, String>> favList = new ArrayList<Map<String,String>>();

    //list for the feed data, which contains data that will be used to populate the favorites list
    ArrayList<FeedUserData> values = new ArrayList<FeedUserData>();

    //declaring the public integer "id" to be used to populate the favorites list by the ids associated
    //with each individual feed user
    public int id;

    TextView textViewName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites);

        // we call this initList function to fill in our list class variable with our favorites
        initFeedList();

        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView favoriteUsersListView = (ListView) findViewById(R.id.favoritesListView);
        //update the XML files referenced below
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, favList, android.R.layout.simple_list_item_1, new String[] {"favorite"}, new int[] {android.R.id.text1});
        favoriteUsersListView.setAdapter(simpleAdpt);

        // setOnItemClickListener tells the activity what to do when a list item is clicked on
        favoriteUsersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openFavoriteUserDetail(position);
            }
        });

    }

    //Add item to adapter
    private void initFeedList() {
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

    // openTeamDetail is called whenever a list item is clicked on
    // it calls for an intent that starts up the team detail activity and sends the team's id over
    // to the activity with the message variable declared at the top of the activity

    // initList simply adds our favorites to the list
    private void initList() {

        //gets the favorite list
        List<Integer> favorites = SharedPreferencesUtility.getFavoriteList(this, "favorites");

        //set default TextView as not visible - if this is true, show it, otherwise keep it not visible
        if (favorites.size() == 0) {
            textViewName = (TextView) findViewById(R.id.favoritesTextView);
            textViewName.setText("You have no favorites yet!");
        } else {

            for (int f : favorites) {

                FeedUserData user = values.get(f);
                favList.add(createFav("favorite", user.getName()));

            }
        }

    }

    public void openFavoriteUserDetail(int position) {

        List<Integer> favorites = SharedPreferencesUtility.getFavoriteList(this, "favorites");

        int temp = favorites.get(position);
        Intent intent = new Intent(this, OtherUserProfileActivity.class);
        String message = String.valueOf(temp);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a team name into out list.
    private HashMap<String, String> createFav(String key, String name) {
        HashMap<String, String> fav = new HashMap<String, String>();
        fav.put(key, name);
        return fav;
    }

}