/**
 * Created by Stephanie Wooten on 11/10/14. Using Teamivore and in-class code.
 */
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.si543.whatsyourstory.OtherUserProfileActivity;
import com.example.si543.whatsyourstory.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MenuActivity extends Activity {

    // the string variable we use for sending messages with intents
    public final static String EXTRA_MESSAGE = "com.example.si543.whatsyourstory.MESSAGE";

    // a list class type must be used when using a list view
    // list items are added to a list view programatically and not through xml
    List<Map<String, String>> menuList = new ArrayList<Map<String,String>>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // we call this initList function to fill in our list class variable with our team names
        initList();

        // adapters are what we use to associate the list variable and its contents with the list view
        ListView optionsListView = (ListView) findViewById(R.id.menuListView);
        //update the XML files referenced below
        SimpleAdapter simpleAdpt = new SimpleAdapter(this, menuList, android.R.layout.simple_list_item_1, new String[] {"menu option"}, new int[] {android.R.id.text1});
        optionsListView.setAdapter(simpleAdpt);

        // setOnItemClickListener tells the activity what to do when a list item is clicked on
        optionsListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parentAdapter, View view, int position,
                                    long id) {
                openMenuList(id);
            }
        });

    }
    // openMenuList is called whenever a list item is clicked on
    // it calls for an intent that starts up the team detail activity and sends the team's id over
    // to the activity with the message variable declared at the top of the activity

    public void openMenuList(long id) {
        Intent intent = new Intent(this, OtherUserProfileActivity.class);
        String message = String.valueOf(id);
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }
    // initList simply adds our team names to the list variable
    // in a real app, this would be where we query our database to retrieve the list of teams, but
    // for the sake of our demo, this hard-coded data is sufficient
    private void initList() {
        menuList.add(createOption("menu option", "Edit My Profile"));
        menuList.add(createOption("menu option", "My Favorites"));
        menuList.add(createOption("menu option", "Messages"));
        menuList.add(createOption("menu option", "Log Out"));

    }

    // this method helps us minimize the amount of repeat calls we need to make in initList to place
    // an option into out list.
    private HashMap<String, String> createOption(String key, String name) {
        HashMap<String, String> team = new HashMap<String, String>();
        team.put(key, name);
        return team;
    }

}