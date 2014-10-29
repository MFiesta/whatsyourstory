package com.example.si543.whatsyourstory;

import android.content.Context;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.io.File;
import java.util.ArrayList;

/**
 * Created by chiahuihsieh on 10/29/14.
 */
public class MySimpleArrayAdapter extends ArrayAdapter<FeedUserData> {
    public MySimpleArrayAdapter(Context context, int layoutResourceId, ArrayList<FeedUserData> values) {
//http://developer.android.com/reference/android/widget/ArrayAdapter.html#ArrayAdapter(android.content.Context, int, java.util.List<T>)
        super(context, layoutResourceId, values);

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//modify the id to match what you have in your xml file (passed when you use “new MySimpleArrayAdapter(context, layoutResourceId, values)”
//fetch corresponding view
        View rowView = super.getView(position, convertView, parent);
        TextView nameTextView = (TextView) rowView.findViewById(R.id.feedName);
        TextView careerTextView = (TextView) rowView.findViewById(R.id.feedCareer);
        TextView locationTextView = (TextView) rowView.findViewById(R.id.feedLocation);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        //set data for the view
        FeedUserData user = getItem(position);
        nameTextView.setText(user.getName());
        careerTextView.setText(user.getCareer());
        locationTextView.setText(user.getLocation());
        String imagePath = user.getImagePath();
        if (imagePath != null) {
            File file = new File(imagePath);
            Uri uri = Uri.fromFile(file);
            imageView.setImageURI(uri);
        }

        return rowView;
    }
}
