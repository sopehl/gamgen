package com.gamgen.controller;

import com.gamgen.model.gamezop.GamezopGame;
import com.gamgen.model.gamezop.GamezopResponse;
import com.gamgen.service.GameService;
import com.google.gson.Gson;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class GamezopController {

    @Autowired
    private GameService gameService;

    @GetMapping("/gamezop")
    public String addGames() {
        HttpRequest httpRequest = HttpRequest.get("https://pub.gamezop.com/v3/games?id=5951&lang=en");

        final HttpResponse httpResponse = httpRequest.send();
        final String bodyResponse = httpResponse.bodyText();

        Gson gson = new Gson();

        final GamezopResponse gamezopResponse = gson.fromJson(bodyResponse, GamezopResponse.class);
        List<GamezopGame> gamezopGames = gamezopResponse.getGames();
        gamezopGames = gamezopGames.stream().sorted((o1, o2) -> Integer.compare(o2.getGamePlays(), o1.getGamePlays()))
                .collect(Collectors.toList());
        gamezopGames.forEach(gamezopGame -> {
            com.gamgen.model.Game gameFirebase = new com.gamgen.model.Game();
            gameFirebase.setId(StringUtils.replaceChars(gamezopGame.getName().getEn(), ' ', '-') + gamezopGame.getCode());
            gameFirebase.setHtml5GameUrl(gamezopGame.getUrl());
            gameFirebase.setHeight(String.valueOf(gamezopGame.getHeight()));
            gameFirebase.setWidth(String.valueOf(gamezopGame.getWidth()));
            gameFirebase.setTitle(gamezopGame.getName().getEn());
            gameFirebase.setDescription(StringUtils.substring(gamezopGame.getDescription().getEn(), 0,1024));
            gameFirebase.setFrameBorder("0");
            gameFirebase.setScrolling("0");
            gameFirebase.setImageUrl(gamezopGame.getAssets().getThumb());
            gameFirebase.setProvider("Gamezop");
            gamezopGame.getCategories().getEn().stream().findFirst().ifPresent(gameFirebase::setCategory);
            gameFirebase.setStatus("OK");
            gameFirebase.setPortrait(gamezopGame.isPortrait());
            gameFirebase.setGamePlays(gamezopGame.getGamePlays());

            gameService.addNewGame(gameFirebase);
        });

        return "OK";
    }

}
