package com.duviv.challenge.player.presentation;

import com.duviv.challenge.player.model.Player;
import com.duviv.challenge.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/api/players")
public class PlayerApi {

    private final PlayerService playerService;

    @Autowired
    public PlayerApi(PlayerService playerService) {
        this.playerService = playerService;
    }

    @GetMapping
    public List<Player> getAllPlayers() {
        return playerService.findAll();
    }

    @GetMapping(value = "/{id}")
    public Player getPlayer(@PathVariable long id) {
        return playerService.findById(id);
    }

    @PostMapping
    public void createPlayer(@RequestBody Player p) {
        if (p.getId() != null) {
            throw new IllegalArgumentException("Cannot create a player with an id !");
        }
        playerService.create(p);
    }

    @DeleteMapping("/{id}")
    public void deletePlayer(@PathVariable long id) {
        playerService.delete(id);
    }
}
