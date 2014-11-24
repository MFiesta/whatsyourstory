package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/13/14.  Creates an item for the side nav drawer list.
 */
public class NavDrawerItem {

    private String title;
    private int count = 0;
    // boolean to set visiblity of the counter
    private boolean isCounterVisible = false;

    public NavDrawerItem(){}

    public NavDrawerItem(String title){
        this.title = title;
    }

    public NavDrawerItem(String title, boolean isCounterVisible, int count){
        this.title = title;
        this.isCounterVisible = isCounterVisible;
        this.count = count;
    }

    public String getTitle(){
        return this.title;
    }

    public int getCount(){
        return this.count;
    }

    public boolean getCounterVisibility(){
        return this.isCounterVisible;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setCount(int count){
        this.count = count;
    }

    public void setCounterVisibility(boolean isCounterVisible){
        this.isCounterVisible = isCounterVisible;
    }
}