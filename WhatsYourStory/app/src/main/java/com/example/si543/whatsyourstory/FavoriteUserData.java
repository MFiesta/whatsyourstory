package com.example.si543.whatsyourstory;

/**
 * Created by Stephanie Wooten on 11/24/14.
 */
public class FavoriteUserData {
    protected String name;
    protected String career;

    public FavoriteUserData(String name, String career) {
        this.name = name;
        this.career = career;
    }
    public String getName() {
        return name;
    }
    public String getCareer() {
        return career;
    }

}
