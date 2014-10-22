package com.example.si543.whatsyourstory;

//Alice Rhee

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class OtherUserProfileActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other_user_profile);
    }


/*    public void Message (View view){
        Intent messageIntent = new Intent (this, MessageActivity.class);
        startActivity(messageIntent);
    }

    */

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