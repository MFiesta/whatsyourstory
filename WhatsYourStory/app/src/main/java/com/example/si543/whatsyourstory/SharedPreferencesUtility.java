package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/17/14 based on code from Teamivore/section discussion.
 */
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

// lets us use a list of string names for the message archive - code adapted from Teamivore

public class SharedPreferencesUtility {

    //method to getStringList for messages
    public static List<String> getStringList(Activity activity, String key) {

        List<String> list = new ArrayList<String>();

        // grab the preferences associated with messages activity
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");


        if(listString.length() != 0) {

            // create an array returning everything in between the semicolons in the messages key
            String[] items = listString.split(";");

            // a for loop that goes through the array and adds each separated string to the list
            for (String i : items) {
                list.add(i);
            }

        }

        return list;

    }

    public static void putTeamList(Activity activity, String key, List<FavoriteUserData> list) {

        List<String> tempList = new ArrayList<String>();

        for(FavoriteUserData t: list) {

            String tempTeamString = t.getName() + ";" +
                    t.getCareer();

            tempList.add(tempTeamString);

        }

        String listString = TextUtils.join(";;", tempList);

        myPutString(activity, key, listString);

    }


    //method to getStringList for favorites
    public static List<FavoriteUserData> getFavoriteList(Activity activity, String key) {

        List<FavoriteUserData> list = new ArrayList<FavoriteUserData>();

        // grab the preferences associated with messages activity
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");


        if(listString.length() != 0) {

            // create an array returning everything in between the semicolons in the messages key
            String[] favorites = listString.split(";");

            // a for loop that goes through the array and adds each separated string to the list
            for (String f : favorites) {
                String[] teamAttributes = f.split(";");

                String name = teamAttributes[0];
                String career = teamAttributes[1];
                String location = teamAttributes[2];
                FavoriteUserData newTeam = new FavoriteUserData(name, career, location);

                list.add(newTeam);
            }

        }

        return list;

    }

    public static void putStringList(Activity activity, String key, List<String> list) {

        // for each string in the list, we want to add it to a new variable and separate the strings
        // by putting semicolons in between them

        // TextUtils.join takes a list or array of objects and places them into one string separated
        // by the string in the first parameter (semicolon in this case)

        String listString = TextUtils.join(";", list);

        // save the new combined string into preferences
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, listString);
        editor.apply();

    }

    // utility that wraps together the sharedpreferences call into one method
    private static void myPutString(Activity activity, String key, String value) {

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.apply();

    }

}
