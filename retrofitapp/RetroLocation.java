package com.example.hazelwang.retrofitapp;

import com.google.gson.annotations.SerializedName;
/*
* It is a RetroLocation class with simple getters and setters
* Inside the class all attributes and responses would be returned
* Make sure the variable names matches with the JSON attributes.
*
* */
public class RetroLocation {
    private String display;
    private String name;

//    public RetroLocation(String display){
//        this.name = name;
//    }
//
//    public String getLocation(){
//        return this.name;
//    }
//
//    public void setLocation(String name){
//        this.name = name;
//    }

    public RetroLocation(String display){
        this.display = display;
    }

    public String getLocation(){
        return this.display;
    }

    public void setLocation(String display){
        this.display = display;
    }
}
