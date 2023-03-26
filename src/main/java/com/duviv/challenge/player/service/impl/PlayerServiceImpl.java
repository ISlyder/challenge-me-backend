package com.duviv.challenge.player.service.impl;

import com.duviv.challenge.player.model.Player;
import com.duviv.challenge.player.repository.PlayerDao;
import com.duviv.challenge.player.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerDao playerDao;

    @Autowired
    public PlayerServiceImpl(PlayerDao playerDao) {
        this.playerDao = playerDao;
    }

    @Override
    public List<Player> findAll() {
        return playerDao.findAll();
    }

    @Override
    public Player findById(Long playerId) {
        return playerDao.findById(playerId)
                .orElseThrow(() -> new NoSuchElementException(String.format("No player with id %d", playerId)));
    }

    @Override
    public void create(Player p) {
        playerDao.save(p);
    }

    @Override
    public void delete(long id) {
        playerDao.deleteById(id);
    }
}
