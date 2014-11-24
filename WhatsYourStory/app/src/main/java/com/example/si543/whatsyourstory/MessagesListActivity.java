package com.example.si543.whatsyourstory;

//Created by Stephanie Wooten on 11/16/14.


import android.app.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.AdapterView;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class MessagesListActivity extends Activity{

    // the string variable we use for sending messages with intents
    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";


    // a list class type must be used when using a list view
    // list items are added to a list view programatically and not through xml
    List<Map<String, String>> msgList = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messagelist);


        /**
         * Check login method wil check user login status
         * If false it will redirect user to login page, else won't do anything
         * */
    //public void checkLogin(){
        // Check login status
        //if(!this.isLoggedIn()){
        //this would call SharedPrefs with the Messages API 

        // we call this initList function to fill in our list class variable with our messages
        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView messagesListView = (ListView) findViewById(R.id.messagesListView);
        //update the XML files referenced below
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, msgList, android.R.layout.simple_list_item_1, new String[] {"messages"}, new int[] {android.R.id.text1});
        messagesListView.setAdapter(simpleAdpt);

        // setOnItemClickListener tells the activity what to do when a list item is clicked on
        messagesListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openMessage(id);
            }
        });

    }

    public void openMessage(long id) {
        Intent intent = new Intent(this, MessageActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

    private void initList() {

        //This is where we need to implement SharedPrefs with the login activity

        //pulls out the "messages"/key strings from the msgList in initData method & adds them to the list
        List<String> messages = SharedPreferencesUtility.getStringList(this, "messages");

        for(String m: messages) {

            msgList.add(createMessage("messages", m));
        }
    }


    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // a team name into out list.
    private HashMap<String, String> createMessage(String key, String name) {
        HashMap<String, String> message = new HashMap<String, String>();
        message.put(key, name);
        return message;
    }

}
