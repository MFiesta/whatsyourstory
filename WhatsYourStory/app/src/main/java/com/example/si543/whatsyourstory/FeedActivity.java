package com.example.si543.whatsyourstory;

import android.app.ActionBar;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class FeedActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);


        ListView feedListView = (ListView) findViewById(R.id.feedListView);

        // set adatper for this listview
        ArrayList<FeedUserData> values = new ArrayList<FeedUserData>();

        FeedUserData user = new FeedUserData("Eytan Adar", "Professor at UM", "Ann Arbor", "adar_eytan.png");
        values.add(user);
        user = new FeedUserData("Kelly Kowatch", "Faculty at UM", "Ann Arbor", "adar_eytan.png");
        values.add(user);
        user = new FeedUserData("Shevon Desai", "faculty at UM", "Detroit", "adar_eytan.png");
        values.add(user);


        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,R.layout.listitem_in_activity_feed, values);
        feedListView.setAdapter(adapter);

        //set listview onitemclicklistener
        feedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                startActivity(new Intent(FeedActivity.this, OtherUserProfileActivity.class));
            }
        });

    }

}