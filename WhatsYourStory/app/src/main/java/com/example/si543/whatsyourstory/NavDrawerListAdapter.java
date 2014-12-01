package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/13/14.
 */

import java.util.ArrayList;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class NavDrawerListAdapter extends BaseAdapter {

    private Context context;
    private ArrayList<NavDrawerItem> navDrawerItems;

    public NavDrawerListAdapter(Context context, ArrayList<NavDrawerItem> navDrawerItems){
        this.context = context;
        this.navDrawerItems = navDrawerItems;
    }
    //gets the current Count for the counter
    @Override
    public int getCount() {
        return navDrawerItems.size();
    }
    //gets the item for the list
    @Override
    public Object getItem(int position) {
        return navDrawerItems.get(position);
    }
    //gets the ID for the item for the list
    @Override
    public long getItemId(int position) {
        return position;
    }
    //gets the view for the item based on the item's position
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater)
                    context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.listitem_in_nav_drawer, null);
        }

        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);
        TextView txtCount = (TextView) convertView.findViewById(R.id.counter);

        txtTitle.setText(navDrawerItems.get(position).getTitle());


        return convertView;
    }

}