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
import android.widget.ListView;
import java.util.ArrayList;


public class FeedActivity extends Activity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks {

    public void showLogoutDialog (View view) {
        LogoutDialog logoutDialog=new LogoutDialog();
        logoutDialog.show(getFragmentManager(),"Logout Dialog");
    }

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

    // set adatper for this listview
    ArrayList<FeedUserData> values = new ArrayList<FeedUserData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feed);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));

        initList();
        // adapters are what we use to associate the list variable and its contents with the list view
        ListView feedListView = (ListView) findViewById(R.id.feedListView);
        MySimpleArrayAdapter adapter = new MySimpleArrayAdapter(this,R.layout.listitem_in_activity_feed, values);
        feedListView.setAdapter(adapter);

        //set listview onitemclicklistener
        feedListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openOtherUserDetail(id);
                //startActivity(new Intent(FeedActivity.this, OtherUserProfileActivity.class));
            }
        });
    };


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
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
    }

    public void onSectionAttached(int position) {
        //Fragment fragment = null;
        switch (position) {
            case 0:
                mTitle = getString(R.string.title_section0);
                //fragment = EditProfileActivity.newInstance(position + 1);
                break;
            case 1:
                mTitle = getString(R.string.title_section1);
                break;
            case 2:
                mTitle = getString(R.string.title_section2);
                break;
            case 3:
                mTitle = getString(R.string.title_section3);
        }
    }

    public void restoreActionBar() {
        ActionBar actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_feed, container, false);
            return rootView;
        }

        @Override
        public void onAttach(Activity activity) {
            super.onAttach(activity);
            ((FeedActivity) activity).onSectionAttached(
                    getArguments().getInt(ARG_SECTION_NUMBER));
        }
    }

}
