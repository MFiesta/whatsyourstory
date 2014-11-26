package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/17/14 based on code from Teamivore/section discussion.
 */
import android.app.Activity;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

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

    //method to getStringList for favorites
    public static List<Integer> getFavoriteList(Activity activity, String key) {

        //List<String> fav = new ArrayList<String>();

        List<Integer> list = new ArrayList<Integer>();

        // grab the preferences associated with messages activity
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(activity);
        String listString = preferences.getString(key, "");

        Log.d("get fav liststring", listString);

        if (listString.length() != 0) {

            String[] favorites = listString.split(";");

            Log.d("favorites list", listString);

            // loop through teams
            for (String t : favorites) {

                Log.d("t first time", t);

                list.add(Integer.parseInt(t));

                Log.d("t after turn into int", t);

            }

        }

        return list;

    }


    public static void putFavoriteList(Activity activity, String key, List<Integer> list) {

        List<String> fav = new ArrayList<String>();

        for (Integer myInt : list) {
            fav.add(String.valueOf(myInt));
        }


        String listString = TextUtils.join(";", fav);

        myPutString(activity, key, listString);

        Log.d("put fav", listString);
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
