package jwd59.finalTest.service;

import java.util.List;

import jwd59.finalTest.model.Player;

public interface PlayerService {

    List<Player> findAll();
    Player findOne(Long id);
}
