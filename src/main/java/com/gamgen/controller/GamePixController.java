package com.gamgen.controller;

import com.gamgen.model.Game;
import com.gamgen.model.GamePixApiData;
import com.gamgen.model.GamePixApiResponse;
import com.gamgen.service.GameService;
import com.google.cloud.firestore.*;
import com.google.gson.Gson;
import jodd.http.HttpRequest;
import jodd.http.HttpResponse;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@RestController
public class GamePixController {

    @Autowired
    private GameService gameService;

    @Autowired
    private Firestore firestore;

    @GetMapping("/gamepix")
    public String addGames() {
        HttpRequest httpRequest = HttpRequest.get("https://games.gamepix.com/games?sid=D96A2");

        final HttpResponse httpResponse = httpRequest.send();
        final String bodyResponse = httpResponse.bodyText();

        Gson gson = new Gson();
        final GamePixApiResponse gamePixApiResponse = gson.fromJson(bodyResponse, GamePixApiResponse.class);

        final ArrayList<GamePixApiData> data = gamePixApiResponse.getData();
        data.forEach(item -> {
            Game game = new Game();
            game.setId(item.getId());
            game.setHtml5GameUrl(item.getUrl());
            game.setHeight(String.valueOf(item.getHeight()));
            game.setWidth(String.valueOf(item.getWidth()));
            game.setTitle(item.getTitle());
            game.setDescription(StringUtils.substring(item.getDescription(), 0,1024));
            game.setFrameBorder("0");
            game.setScrolling("0");
            game.setImageUrl(item.getThumbnailUrl100());
            game.setStatus("OK");

            gameService.addNewGame(game);
        });

        return "OK";
    }

    @GetMapping("/gamepix/firebase")
    public String addGamesFirebase() {
        HttpRequest httpRequest = HttpRequest.get("https://games.gamepix.com/games?sid=D96A2&order=q");

        final HttpResponse httpResponse = httpRequest.send();
        final String bodyResponse = httpResponse.bodyText();

        Gson gson = new Gson();
        final GamePixApiResponse gamePixApiResponse = gson.fromJson(bodyResponse, GamePixApiResponse.class);

        final ArrayList<GamePixApiData> data = gamePixApiResponse.getData();

        int i = 0;

        for (GamePixApiData item : data) {
            final String itemId = item.getId();
            Game game = new Game();
            game.setId(itemId);
            game.setHtml5GameUrl(item.getUrl());
            game.setHeight(String.valueOf(item.getHeight()));
            game.setWidth(String.valueOf(item.getWidth()));
            game.setTitle(item.getTitle());
            game.setDescription(StringUtils.substring(item.getDescription(), 0,1024));
            game.setFrameBorder("0");
            game.setScrolling("0");
            game.setImageUrl(item.getThumbnailUrl100());
            game.setStatus("OK");
            game.setProvider("gamepix");
            game.setCreatedDate(item.getCreation());

            firestore.collection("game").document(itemId).set(game);
            i++;

            if (i == 1000) {
                break;
            }
        }

        return "OK";
    }

    @GetMapping("/gamepix/firebase/page")
    public List<Game> get(@RequestParam(name = "p",required = false) String page) throws ExecutionException, InterruptedException, TimeoutException {
        final CollectionReference gameCollection = firestore.collection("game");
        List<QueryDocumentSnapshot> docSnap;
        if (StringUtils.isEmpty(page)) {
            docSnap = gameCollection.limit(25).get().get(30, TimeUnit.SECONDS).getDocuments();
        } else {
            final DocumentSnapshot nextPageStart = gameCollection.document(page).get().get();
            final Query query = gameCollection.limit(25).startAfter(nextPageStart);
            docSnap = query.get().get().getDocuments();
        }

        List<Game> gameList = new ArrayList<>();
        docSnap.forEach(item -> {
            final Game game = item.toObject(Game.class);
            gameList.add(game);
        });

        return gameList;
    }

}
