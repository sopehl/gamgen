package com.gamgen.model.gamezop;

import java.util.ArrayList;

public class GamezopResponse {

    public ArrayList<GamezopGame> games;

    public String publisherName;

    public ArrayList<GamezopGame> getGames() {
        return games;
    }

    public void setGames(ArrayList<GamezopGame> gamezopGames) {
        this.games = gamezopGames;
    }

    public String getPublisherName() {
        return publisherName;
    }

    public void setPublisherName(String publisherName) {
        this.publisherName = publisherName;
    }
}
