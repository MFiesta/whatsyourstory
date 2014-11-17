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
    List<Map<String, String>> msgList = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_messages);

        // we call this initList function to fill in our list class variable with our messages
        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView messagesListView = (ListView) findViewById(R.id.messagesListView);
        //update the XML files referenced below
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, msgList, android.R.layout.simple_list_item_1, new String[] {"messages"}, new int[] {android.R.id.text1});
        messagesListView.setAdapter(simpleAdpt);

        // setOnItemClickListener tells the activity what to do when a list item is clicked on
        //favoriteUsersListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            //public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    //long id) {
                //openFavoriteUserDetail(id);
            //}
        //});

    }

    private void initList() {
        //pulls out the "messages"/key strings from the msgList in initData method
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
