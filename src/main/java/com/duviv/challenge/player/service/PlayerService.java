package com.duviv.challenge.player.service;

import com.duviv.challenge.player.model.Player;

import java.util.List;
import java.util.Optional;

public interface PlayerService {

    List<Player> findAll();

    Player findById(Long playerId);

    void create(Player p);

    void delete(long id);
}
