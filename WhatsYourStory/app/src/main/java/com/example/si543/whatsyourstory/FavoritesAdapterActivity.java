package com.example.si543.whatsyourstory;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by alicerhee on 10/25/14.
 */
public class FavoritesAdapterActivity extends BaseAdapter{
        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 0;
        }

        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }

        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return arg0;
        }

        @Override
        public View getView(int arg0, View arg1, ViewGroup arg2) {
            // TODO Auto-generated method stub
            return null;
        }
    public class FavoritesList {
        String favoriteUserName;
        String favoriteUserDescription;

        public List<FavoritesList> get(int arg0) {
        }
    }
    public List<FavoritesList> getDataForListView()
    {
        List<FavoritesList> favoriteUsersList = new ArrayList<FavoritesList>();

        for(int i=0;i<10;i++)
        {

            FavoritesList chapter = new FavoritesList();
            chapter.favoriteUserName = "Eytan Adar "+i;
            chapter.favoriteUserDescription = "This is description for chapter "+i;
            favoriteUsersList.add(chapter);
        }

        return favoriteUsersList;
        List<FavoritesList> favoriteUsersList = getDataForListView();
        return favoriteUsersList.size();
        @Override
        public FavoritesList getItem(int arg0) {
        // TODO Auto-generated method stub
        return FavoritesList.get(arg0);
        return arg0;
        LayoutInflater inflater = (LayoutInflater) ListViewWithBaseAdapter.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.activity_favorites_listitem, arg2,false);
        if(arg1==null)
        {
            LayoutInflater inflater = (LayoutInflater) ListViewWithBaseAdapter.this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            arg1 = inflater.inflate(R.layout.activity_favorites_listitem, arg2,false);
            TextView favoriteUserName = (TextView)arg1.findViewById(R.id.textView1);
            TextView favoriteUserDescription = (TextView)arg1.findViewById(R.id.textView2);
            FavoritesList chapter = favoriteUsersList.get(arg0);
            favoriteUserName.setText(chapter.favoriteUserName);
            favoriteUserDescription.setText(chapter.favoriteUserDescription);
            return arg1;
            FavoritesAdapterActivity newListAdapter = new FavoritesAdapterActivity();
            ListView activity_favorites = (ListView)findViewById(R.id.favoritesListView);
            activity_favorites.setAdapter(newListAdapter);

            public void onItemClick(AdapterView <?> arg0, View arg1, int arg2, long arg3)
                public FavoritesList getCodeLearnChapter(int position)
        {
            return favoriteUsersList.get(position);
        }
            activity_favorites.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {

                FavoritesList chapter = newListAdapter.getFavoritesList(arg2);

                Toast.makeText(ListViewWithBaseAdapter.this, chapter.favoriteUserName, Toast.LENGTH_LONG).show();

            }
        });
        }

    }
    }

}
}
