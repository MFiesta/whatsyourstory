package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class OtherUserProfileActivity extends Activity {


    ArrayList<FeedUserData> values = new ArrayList<FeedUserData>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);

        initList();

        Intent intent = getIntent();
        String message = intent.getStringExtra(FeedActivity.EXTRA_MESSAGE);

        int id = (int) Long.parseLong(message);

        // Create the text view

        ImageView imageViewUserPicture = (ImageView) findViewById(R.id.userPicture);
        String imagePath = values.get(id).getImagePath();

        if (imagePath != null) {

            try {
                imageViewUserPicture.setImageBitmap(BitmapFactory.decodeStream(getAssets().open(imagePath)));
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        TextView textViewName = (TextView) findViewById(R.id.textView_OtherUserName);
        textViewName.setText(values.get(id).getName());


        TextView textViewCareer = (TextView) findViewById(R.id.textView_OtherUserCareer);
        textViewCareer.setText(values.get(id).getCareer());

        TextView textViewLocation = (TextView) findViewById(R.id.textView_OtherUserLocation);
        textViewLocation.setText(values.get(id).getLocation());
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

//Message Intent 
   public void Message (View view){
       //Add message activity intents here

    }

//Takes user to favorites list
    public void Favorite (View view){
        Intent favoriteIntent = new Intent (this, FavoritesActivity.class);
        startActivity(favoriteIntent);
    }

//Action Bar - star
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.other_user_profile, menu);
        return true;
    }

    //@Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //if (id == R.id.action_settings) {
        //    return true;
        //}
        //return super.onOptionsItemSelected(item);
    }
//visibility contingent on user's approval to see their calendar

//    public void ViewCalendar (View view){
//        Intent calendarIntent = new Intent (this, CalendarActivity.class);
//        startActivity(calendarIntent);
//    }
    //fill in list items from the other user's Choose interests Activity screen
    //List-set up 2 lists here for the skills and experience of the user
    //skills list = new ArrayList<~>();
    //  initList();
    //   ListView skillsListView = (Listview)
    // private void initlist(){
    //   List.add(createskill("skiing")
    // }
