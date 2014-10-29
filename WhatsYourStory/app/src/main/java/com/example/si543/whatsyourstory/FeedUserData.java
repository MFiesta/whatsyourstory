package com.example.si543.whatsyourstory;

/**
 * Created by chiahuihsieh on 10/29/14.
 */
public class FeedUserData {
    protected String name;
    protected String contact;
    protected String thirdline;
    protected String imagePath;

    public FeedUserData(String name, String contact, String thirdline, String imagePath) {
        this.name = name;
        this.contact = contact;
        this.thirdline = thirdline;
        this.imagePath = imagePath;
    }
    public String getName() {
        return name;
    }
    public String getContact() {
        return contact;
    }
    public String getThirdline() {
        return thirdline;
    }
    public String getImagePath() {
        return imagePath;
    }
}

