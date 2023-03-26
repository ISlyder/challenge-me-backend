package com.duviv.challenge.game.service;

import com.duviv.challenge.game.model.Game;

import java.util.List;

public interface GameService {
    Game findById(long id);

    List<Game> findAll();

    void create(Game g);

    void delete(long id);
}
