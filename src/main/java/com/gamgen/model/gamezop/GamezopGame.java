package com.gamgen.model.gamezop;

public class GamezopGame {

    public String code;
    public String url;
    public Name name;
    public boolean isPortrait;
    public Description description;
    public GamePreviews gamePreviews;
    public Assets assets;
    public Categories categories;
    public Tags tags;
    public int width;
    public int height;
    public String colorMuted;
    public String colorVibrant;
    public boolean privateAllowed;
    public double rating;
    public int numberOfRatings;
    public int gamePlays;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Name getName() {
        return name;
    }

    public void setName(Name name) {
        this.name = name;
    }

    public boolean isPortrait() {
        return isPortrait;
    }

    public void setPortrait(boolean portrait) {
        isPortrait = portrait;
    }

    public Description getDescription() {
        return description;
    }

    public void setDescription(Description description) {
        this.description = description;
    }

    public GamePreviews getGamePreviews() {
        return gamePreviews;
    }

    public void setGamePreviews(GamePreviews gamePreviews) {
        this.gamePreviews = gamePreviews;
    }

    public Assets getAssets() {
        return assets;
    }

    public void setAssets(Assets assets) {
        this.assets = assets;
    }

    public Categories getCategories() {
        return categories;
    }

    public void setCategories(Categories categories) {
        this.categories = categories;
    }

    public Tags getTags() {
        return tags;
    }

    public void setTags(Tags tags) {
        this.tags = tags;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getColorMuted() {
        return colorMuted;
    }

    public void setColorMuted(String colorMuted) {
        this.colorMuted = colorMuted;
    }

    public String getColorVibrant() {
        return colorVibrant;
    }

    public void setColorVibrant(String colorVibrant) {
        this.colorVibrant = colorVibrant;
    }

    public boolean isPrivateAllowed() {
        return privateAllowed;
    }

    public void setPrivateAllowed(boolean privateAllowed) {
        this.privateAllowed = privateAllowed;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getNumberOfRatings() {
        return numberOfRatings;
    }

    public void setNumberOfRatings(int numberOfRatings) {
        this.numberOfRatings = numberOfRatings;
    }

    public int getGamePlays() {
        return gamePlays;
    }

    public void setGamePlays(int gamePlays) {
        this.gamePlays = gamePlays;
    }
}
