package com.myapplication;

/**
 * Created by Juphoon on 2018/8/22.
 */

public class GroupItem {
    private String name;
    private int imageId;

    public GroupItem(String name , int imageId){
        this.name = name;
        this.imageId = imageId;
    }

    public GroupItem(String name){
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public int getImageId(){
        return imageId;
    }
}
