package com.example.mvpapplication.bean;

/**
 * Copyright 2022 bejson.com
 */
import java.util.List;

/**
 * Auto-generated: 2022-05-04 12:51:29
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class Tabs {

    private String name;
    private List<String> pictures;
    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setPictures(List<String> pictures) {
        this.pictures = pictures;
    }
    public List<String> getPictures() {
        return pictures;
    }

    @Override
    public String toString() {
        return "Tabs{" +
                "name='" + name + '\'' +
                ", pictures=" + pictures +
                '}';
    }
}