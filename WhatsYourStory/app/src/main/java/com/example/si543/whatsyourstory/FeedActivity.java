//Created by chiahuihsieh & Stephanie Wooten

package com.example.si543.whatsyourstory;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.NavUtils;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class FeedActivity extends Activity {

    public void showLogoutDialog (View view) {
        LogoutDialog logoutDialog=new LogoutDialog();
        logoutDialog.show(getFragmentManager(),"Logout Dialog");
    }

    private DrawerLayout mDrawerLayout;
    private ListView mDrawerList;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView feedList;

    //nav drawer title
    private CharSequence mDrawerTitle;

    //app title
    private CharSequence mTitle;


    //menu items
    private String[] navMenuTitles;

    public NavDrawerListAdapter adapter;

    // set adapter for feed's listview
    ArrayList<FeedUserData> values = new ArrayList<FeedUserData>();

    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        // enabling action bar app icon and behaving it as toggle button
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);

        mTitle = mDrawerTitle = "What's Your Story?";

        initData();

        //load nav drawer list items
        navMenuTitles = getResources().getStringArray(R.array.nav_drawer_items);

        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.drawer_list);
        feedList = (ListView) findViewById(R.id.feedListView);

        ArrayList<NavDrawerItem> navDrawerItems = new ArrayList<NavDrawerItem>();

        //adding nav drawer items to the array
        //Home - Takes user back to feed page
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[0]));
        //My Profile
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[1]));
        //Messages - Need Counter
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[2], true, "3"));
        //Favorites - Do we need a counter for this?
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[3]));
        //Log Out
        navDrawerItems.add(new NavDrawerItem(navMenuTitles[4]));

        //set the nav drawer list adapter
        adapter = new NavDrawerListAdapter(getApplicationContext(), navDrawerItems);
        mDrawerList.setAdapter(adapter);

        mDrawerLayout.setDrawerListener(mDrawerToggle);

        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
                R.drawable.ic_drawer, //nav menu toggle icon
                R.string.app_name, // nav drawer open - description for accessibility
                R.string.app_name // nav drawer close - description for accessibility
        ){
            public void onDrawerClosed(View view) {
                getActionBar().setTitle(mTitle);
                // calling onPrepareOptionsMenu() to show action bar icons
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                getActionBar().setTitle(mDrawerTitle);
                // calling onPrepareOptionsMenu() to hide action bar icons
                invalidateOptionsMenu();
            }
        };

        if (savedInstanceState == null) {
            // on first time display view HomeFragment
            displayView(0);
        }

        mDrawerList.setOnItemClickListener(new SlideMenuClickListener());

        initList();
        // adapters are what we use to associate the list variable and its contents with the list view
        MySimpleArrayAdapter feedAdapter = new MySimpleArrayAdapter(this, R.layout.listitem_in_activity_feed, values);
        feedList.setAdapter(feedAdapter);

        //set listview onitemclicklistener
        feedList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openOtherUserDetail(id);
                startActivity(new Intent(FeedActivity.this, OtherUserProfileActivity.class));
            }
        });
    }

        //copy teamivore
        // openTeamDetail is called whenever a list item is clicked on
        // it calls for an intent that starts up the team detail activity and sends the team's id over
        // to the activity with the message variable declared at the top of the activity
        public void openOtherUserDetail(long id) {
            Intent intent = new Intent(this, OtherUserProfileActivity.class);
            String message = String.valueOf(id);
            intent.putExtra(EXTRA_MESSAGE, message);
            startActivity(intent);
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.global, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        //toggle nav drawer on selecting title/hamburger icon
        if (mDrawerToggle.onOptionsItemSelected(item)){
            return true;
        }
        //Handle action bar actions click
        switch (item.getItemId()) {
            case R.id.action_settings:
                NavUtils.navigateUpFromSameTask(this);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }


    //Called when invalidateOptionsMenu() is triggered - ??
    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        //hide action bar items when nav drawer is open
        boolean drawerOpen = mDrawerLayout.isDrawerOpen(mDrawerList);
        menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }
    //set title on screen app title
    @Override
    public void setTitle(CharSequence title) {
        mTitle = "What's Your Story";
        getActionBar().setTitle(mTitle);
    }

    /**
     * When using the ActionBarDrawerToggle, you must call it during
     * onPostCreate() and onConfigurationChanged()...
     */

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        mDrawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Pass any configuration change to the drawer toggle
        mDrawerToggle.onConfigurationChanged(newConfig);
    }

    //nav drawer click listener
    private class SlideMenuClickListener implements
            ListView.OnItemClickListener {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            //display view for selected nav drawer item
            displayView(position);
        }
    }

    //display fragment view for selected nav drawer item
    private void displayView(int position) {
        Fragment fragment = null;
        switch (position) {
            //If user selects "Home" on nav drawer, it closes drawer and takes them to feed
            case 0:
                fragment = new HomeFragment();
                break;
            //If user selects "My Profile" - Takes to My Profile Activity
            case 1:
                Intent editProfile = new Intent(FeedActivity.this, MyProfileActivity.class);
                startActivity(editProfile);
                break;
            //If user selects "Messages" - Takes user to Message archive
            case 2:
                Intent viewMsgs = new Intent(FeedActivity.this, MessagesActivity.class);
                startActivity(viewMsgs);
                break;
            //If user selects "Favorites" - takes them to list of favorited contacts
            case 3:
                Intent intent = new Intent(FeedActivity.this, FavoritesActivity.class);
                startActivity(intent);
                break;
            //If user selects "Log Out" - Takes them to homepage
            case 4:
                Intent logOut = new Intent(FeedActivity.this, LogInActivity.class);
                startActivity(logOut);
                break;
            default:
                break;
        }

        if(fragment != null) {
            FragmentManager fragmentManager = getFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.frame_container, fragment).commit();

            //update selected item and title, close drawer
            mDrawerList.setItemChecked(position, true);
            mDrawerList.setSelection(position);
            setTitle(navMenuTitles[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        } else {
            //error in creating fragment
            Log.e("FeedActivity", "Error in creating fragment");
        }

    }

    //initialize the message list from a logged in user
    private void initData() {

        List<String> msgList = new ArrayList<String>();

        msgList.add("Message From: Eytan Adar;Message From: Kelly Kowatch;Message From: Tony Stark");

        SharedPreferencesUtility.putStringList(this, "messages",  msgList);

    }



}
