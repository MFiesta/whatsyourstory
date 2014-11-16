package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/16/14.
 */

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class MessagesFragment extends Fragment {
    public MessagesFragment(){}

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_messages, container, false);

        return rootView;
    }

}
