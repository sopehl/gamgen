package com.gamgen.entity;

import java.util.Date;

public class GameEntity {

    private String id;

    private String imageUrl;

    private String html5GameUrl;

    private String height;

    private String width;

    private String frameBorder;

    private String scrolling;

    private String title;

    private String status;

    private Date createdDate;

    private String description;

    private String provider;

    private String category;

    private Boolean portrait;

    private int gamePlays;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getHtml5GameUrl() {
        return html5GameUrl;
    }

    public void setHtml5GameUrl(String html5GameUrl) {
        this.html5GameUrl = html5GameUrl;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }

    public String getFrameBorder() {
        return frameBorder;
    }

    public void setFrameBorder(String frameBorder) {
        this.frameBorder = frameBorder;
    }

    public String getScrolling() {
        return scrolling;
    }

    public void setScrolling(String scrolling) {
        this.scrolling = scrolling;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getProvider() {
        return provider;
    }

    public void setProvider(String provider) {
        this.provider = provider;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCategory() {
        return category;
    }

    public Boolean getPortrait() {
        return portrait;
    }

    public void setPortrait(Boolean portrait) {
        this.portrait = portrait;
    }

    public void setGamePlays(int gamePlays) {
        this.gamePlays = gamePlays;
    }

    public int getGamePlays() {
        return gamePlays;
    }
}
