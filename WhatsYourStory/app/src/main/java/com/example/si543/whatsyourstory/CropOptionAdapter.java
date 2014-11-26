package com.example.si543.whatsyourstory;

/**
 * Created by alicerhee on 11/24/14.
 */

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import android.content.Context;

import java.util.ArrayList;

public class CropOptionAdapter extends ArrayAdapter<SetMyInitProfileActivity.CropOption>{

    private ArrayList<SetMyInitProfileActivity.CropOption> mOptions;
    private LayoutInflater mInflater;

    public CropOptionAdapter(Context context, ArrayList<SetMyInitProfileActivity.CropOption> options) {
        super(context, R.layout.crop_selector, options);

        mOptions 	= options;

        mInflater	= LayoutInflater.from(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup group) {
        if (convertView == null)
            convertView = mInflater.inflate(R.layout.crop_selector, null);

        SetMyInitProfileActivity.CropOption item = mOptions.get(position);

        if (item != null) {
            ((ImageView) convertView.findViewById(R.id.iv_icon)).setImageDrawable(item.icon);
            ((TextView) convertView.findViewById(R.id.tv_name)).setText(item.title);

            return convertView;
        }

        return null;
    }
}
