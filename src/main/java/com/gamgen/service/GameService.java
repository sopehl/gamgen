package com.gamgen.service;

import com.gamgen.entity.GameEntity;
import com.gamgen.model.Game;
import com.gamgen.utils.RandomUtils;
import com.google.cloud.firestore.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

@Service
public class GameService {

    @Autowired
    private Firestore firestore;

    public List<Game> findAllGames(String afterItem) throws ExecutionException, InterruptedException, TimeoutException {
        final CollectionReference gameCollection = firestore.collection("game");
        List<QueryDocumentSnapshot> docSnap;
        if (StringUtils.isEmpty(afterItem)) {
            docSnap = gameCollection
                    .whereEqualTo("portrait", true)
                    .orderBy("gamePlays", Query.Direction.DESCENDING)
                    .limit(16)
                    .get().get(30, TimeUnit.SECONDS).getDocuments();
        } else {
            final DocumentSnapshot nextPageStart = gameCollection.document(afterItem).get().get();
            final Query query = gameCollection
                    .whereEqualTo("portrait", true)
                    .orderBy("gamePlays", Query.Direction.DESCENDING)
                    .limit(16)
                    .startAfter(nextPageStart);
            docSnap = query.get().get().getDocuments();
        }

        List<Game> gameList = new ArrayList<>();
        docSnap.forEach(item -> {
            final Game game = item.toObject(Game.class);
            gameList.add(game);
        });

        gameList.add(2, new Game());
        gameList.add(4, new Game());
        gameList.add(8, new Game());
        gameList.add(14, new Game());

        return gameList;
    }

    public Game getGameById(String id) throws ExecutionException, InterruptedException {
        final CollectionReference gameCollection = firestore.collection("game");
        final DocumentSnapshot documentSnapshot = gameCollection.document(id).get().get();
        final GameEntity gameEntity = documentSnapshot.toObject(GameEntity.class);

        Game game = new Game();
        game.setId(gameEntity.getId());
        game.setImageUrl(gameEntity.getImageUrl());
        game.setHtml5GameUrl(gameEntity.getHtml5GameUrl());
        game.setTitle(gameEntity.getTitle());
        if (Integer.parseInt(gameEntity.getHeight()) > 600) {
            game.setHeight("600");
        } else {
            game.setHeight(gameEntity.getHeight());
        }
        game.setWidth(gameEntity.getWidth());
        game.setCreatedDate(new Date());
        game.setStatus(gameEntity.getStatus());
        game.setFrameBorder(gameEntity.getFrameBorder());
        game.setScrolling(gameEntity.getScrolling());
        game.setDescription(gameEntity.getDescription());

        return game;
    }

    public void addNewGame(Game game) {
        GameEntity entity = new GameEntity();

        String id;
        if (StringUtils.isNotEmpty(game.getId())) {
            entity.setId(game.getId());
            id = game.getId();
        } else {
            final String unique = RandomUtils.generateUnique();
            entity.setId(unique);
            id = unique;
        }

        entity.setImageUrl(game.getImageUrl());
        entity.setHtml5GameUrl(game.getHtml5GameUrl());
        entity.setTitle(game.getTitle());
        entity.setHeight(game.getHeight());
        entity.setWidth(game.getWidth());
        entity.setCreatedDate(new Date());
        entity.setStatus(game.getStatus());
        entity.setFrameBorder(game.getFrameBorder());
        entity.setScrolling(game.getScrolling());
        entity.setDescription(game.getDescription());
        entity.setCategory(game.getCategory());
        entity.setPortrait(game.getPortrait());
        entity.setGamePlays(game.getGamePlays());
        entity.setProvider(game.getProvider());

        firestore.collection("game").document(id).set(entity);
    }

}
