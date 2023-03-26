package com.duviv.challenge.game.presentation;

import com.duviv.challenge.game.model.Game;
import com.duviv.challenge.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/games")
public class GameApi {

    private final GameService gameService;

    @Autowired
    public GameApi(GameService gameService) {
        this.gameService = gameService;
    }

    @GetMapping
    public List<Game> getGames() {
        return this.gameService.findAll();
    }

    @GetMapping("/{id}")
    public Game getGame(@PathVariable long id) {
        return this.gameService.findById(id);
    }

    @PostMapping
    public void create(@RequestBody Game game) {
        this.gameService.create(game);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        this.gameService.delete(id);
    }


}
