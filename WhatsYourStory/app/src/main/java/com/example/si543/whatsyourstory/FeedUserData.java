package com.example.si543.whatsyourstory;

/**
 * Created by chiahuihsieh on 10/29/14.
 */

//Defining a model, given a Java object that has certain fields defined a FeedUserData class:
public class FeedUserData {
    protected String name;
    protected String career;
    protected String location;
    protected String imagePath;

    public FeedUserData(String name, String career, String location, String imagePath) {
        this.name = name;
        this.career = career;
        this.location = location;
        this.imagePath = imagePath;
    }
    public String getName() {
        return name;
    }
    public String getCareer() {
        return career;
    }
    public String getLocation() {
        return location;
    }
    public String getImagePath() {
        return imagePath;
    }
}

