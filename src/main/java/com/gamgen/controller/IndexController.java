package com.gamgen.controller;

import com.gamgen.model.Game;
import com.gamgen.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@Controller
public class IndexController {

    @Autowired
    private GameService gameService;

    @GetMapping("/")
    public String openIndexPage(Model model, @RequestParam(required = false) String pn) throws ExecutionException, InterruptedException, TimeoutException {
        final List<Game> allGames = gameService.findAllGames(pn);
        final String lastElementId = Objects.requireNonNull(CollectionUtils.lastElement(allGames)).getId();
        model.addAttribute("title", "Easy Kid Game,Play,Jump,Puzzle,Junior,Sport,Strategy");
        model.addAttribute("nextPn", lastElementId);
        model.addAttribute("gameList", allGames);
        model.addAttribute("descContent", "For the kids, we publish the easy and small games(html5). The easykidgame.com supports by mobile and tablet devices. The newest easy games for the child level.");
        return "index";
    }

    @GetMapping("/play")
    public String play(Model model, @RequestParam String id) throws ExecutionException, InterruptedException {
        final Game game = gameService.getGameById(id);
        model.addAttribute("game", game);
        model.addAttribute("title", game.getTitle());
        model.addAttribute("descContent", game.getDescription());
        return "play";
    }

    @GetMapping("/about")
    public String about() throws ExecutionException, InterruptedException {
        return "about";
    }

    @ResponseBody
    @PostMapping("/game")
    public String addNewGame(@RequestBody Game game) {
        gameService.addNewGame(game);
        return "OK";
    }

}
