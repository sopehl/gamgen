package com.gamgen.model.gamezop;

import java.util.ArrayList;

public class Assets {

    public String cover;
    public String brick;
    public String thumb;
    public String wall;
    public String square;
    public ArrayList<String> screens;
    public String coverTiny;
    public String brickTiny;

    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    public String getBrick() {
        return brick;
    }

    public void setBrick(String brick) {
        this.brick = brick;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getWall() {
        return wall;
    }

    public void setWall(String wall) {
        this.wall = wall;
    }

    public String getSquare() {
        return square;
    }

    public void setSquare(String square) {
        this.square = square;
    }

    public ArrayList<String> getScreens() {
        return screens;
    }

    public void setScreens(ArrayList<String> screens) {
        this.screens = screens;
    }

    public String getCoverTiny() {
        return coverTiny;
    }

    public void setCoverTiny(String coverTiny) {
        this.coverTiny = coverTiny;
    }

    public String getBrickTiny() {
        return brickTiny;
    }

    public void setBrickTiny(String brickTiny) {
        this.brickTiny = brickTiny;
    }
}
