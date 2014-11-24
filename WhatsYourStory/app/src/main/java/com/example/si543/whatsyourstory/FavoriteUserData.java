package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/24/14.
 */
public class FavoriteUserData {
    protected String name;
    protected String career;
    protected String location;

    public FavoriteUserData(String name, String career, String location) {
        this.name = name;
        this.career = career;
        this.location = location;
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

}
