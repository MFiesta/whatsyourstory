package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.net.Uri;

public class OtherUserProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);
    }


   public void Message (View view){
       Intent sendIntent = new Intent(Intent.ACTION_VIEW);
       sendIntent.setData(Uri.parse("sms:"));
    }

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

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
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
}