package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/16/14.
 */

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessagesActivity extends Activity{

    // the string variable we use for sending messages with intents
    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

    // a list class type must be used when using a list view
    // list items are added to a list view programatically and not through xml
    List<Map<String, String>> messagesList = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_messages);

        // we call this initList function to fill in our list class variable with our team names
        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView archivedmessagesListView = (ListView) findViewById(R.id.messagesListView);
        //update the XML files referenced below
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, messagesList, android.R.layout.simple_list_item_1, new String[] {"message"}, new int[] {android.R.id.text1});
        archivedmessagesListView.setAdapter(simpleAdpt);

        // setOnItemClickListener tells the activity what to do when a list item is clicked on
        //favoriteUsersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    //long id) {
                //openFavoriteUserDetail(id);
            //}
        //});

    }

    // initList simply adds our team names to the list variable
    // in a real app, this would be where we query our database to retrieve the list of teams, but
    // for the sake of our demo, this hard-coded data is sufficient
    private void initList() {
        messagesList.add(createTeam("message", "Eytan Adar"));
        messagesList.add(createTeam("message", "Mark Newman"));
        messagesList.add(createTeam("message", "Joyojeet Pal"));
    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a team name into out list. I (Alice) am keeping the variable 'team' for convenience.
    private HashMap<String, String> createTeam(String key, String name) {
        HashMap<String, String> team = new HashMap<String, String>();
        team.put(key, name);
        return team;
    }

}
