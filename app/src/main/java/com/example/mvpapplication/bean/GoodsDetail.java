package com.example.mvpapplication.bean;

/**
 * Copyright 2022 bejson.com
 */
import java.util.Date;
import java.util.List;

/**
 * Auto-generated: 2022-05-04 12:51:29
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class GoodsDetail {

    private String content;
    private List<String> banners;
    private List<Tabs> tabs;
    private String specifications;
    private String inventory;
    private int id;
    private String name;
    private String description;
    private int price;
    private String thumb;
    public void setContent(String content) {
        this.content = content;
    }
    public String getContent() {
        return content;
    }

    public void setBanners(List<String> banners) {
        this.banners = banners;
    }
    public List<String> getBanners() {
        return banners;
    }

    public void setTabs(List<Tabs> tabs) {
        this.tabs = tabs;
    }
    public List<Tabs> getTabs() {
        return tabs;
    }

    public void setSpecifications(String specifications) {
        this.specifications = specifications;
    }
    public String getSpecifications() {
        return specifications;
    }

    public void setInventory(String inventory) {
        this.inventory = inventory;
    }
    public String getInventory() {
        return inventory;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    public int getPrice() {
        return price;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }
    public String getThumb() {
        return thumb;
    }

    @Override
    public String toString() {
        return "GoodsDetail{" +
                "content='" + content + '\'' +
                ", banners=" + banners +
                ", tabs=" + tabs +
                ", specifications='" + specifications + '\'' +
                ", inventory='" + inventory + '\'' +
                ", id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", price=" + price +
                ", thumb='" + thumb + '\'' +
                '}';
    }
}