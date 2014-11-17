package com.example.si543.whatsyourstory;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by chiahuihsieh on 10/27/14. - Modified by Stephanie Wooten 11/14
 */
public class EditProfileFragment extends Fragment {

    public EditProfileFragment(){}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_profile_editing, container, false);

        return rootView;
    }

}

