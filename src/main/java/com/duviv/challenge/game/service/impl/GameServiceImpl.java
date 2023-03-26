package com.duviv.challenge.game.service.impl;

import com.duviv.challenge.game.model.Game;
import com.duviv.challenge.game.repository.GameRepository;
import com.duviv.challenge.game.service.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class GameServiceImpl implements GameService {

    private final GameRepository gameRepository;

    @Autowired
    public GameServiceImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    @Override
    public Game findById(long id) {
        return gameRepository.findById(id)
                .orElseThrow(() -> new NoSuchElementException(String.format("No game with id %d", id)));
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public void create(Game g) {
        gameRepository.save(g);
    }

    @Override
    public void delete(long id) {
        gameRepository.deleteById(id);
    }
}
