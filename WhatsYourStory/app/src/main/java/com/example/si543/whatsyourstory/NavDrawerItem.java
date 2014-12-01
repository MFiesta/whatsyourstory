package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/13/14.  Creates an item for the side nav drawer list.
 */
public class NavDrawerItem {

    private String title;
    private String count = "0";
    // boolean to set visiblity of the counter
    private boolean isCounterVisible = false;

    public NavDrawerItem(){}

    public NavDrawerItem(String title){
        this.title = title;
    }

    public String getTitle(){
        return this.title;
    }


    public void setTitle(String title){
        this.title = title;
    }

}