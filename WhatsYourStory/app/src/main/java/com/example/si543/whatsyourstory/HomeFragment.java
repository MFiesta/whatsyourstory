//Created by Stephanie Wooten on 11/14/14.


package com.example.si543.whatsyourstory;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import static android.content.Intent.getIntent;


public class HomeFragment extends Fragment {
    public HomeFragment(){}

    // set adapter for feed's listview
    ArrayList<FeedUserData> values = new ArrayList<FeedUserData>();

    int id;

    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
        ListView feedList = (ListView) rootView.findViewById(R.id.feedListView);

        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        MySimpleArrayAdapter feedAdapter = new MySimpleArrayAdapter(this.getActivity(), R.layout.listitem_in_activity_feed, values);
        feedList.setAdapter(feedAdapter);

        //set listview onitemclicklistener
        feedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                Intent intent = new Intent(getActivity(), OtherUserProfileActivity.class);
                String message = String.valueOf(id);
                intent.putExtra(EXTRA_MESSAGE, message);
                startActivity(intent);
            }
        });

        return rootView;


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


    }

