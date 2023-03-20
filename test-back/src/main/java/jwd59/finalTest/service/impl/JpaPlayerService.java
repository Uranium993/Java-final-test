package jwd59.finalTest.service.impl;

import jwd59.finalTest.model.Player;
import jwd59.finalTest.repository.PlayerRepository;
import jwd59.finalTest.service.PlayerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaPlayerService implements PlayerService {

    @Autowired
    private PlayerRepository playerRepository;

    @Override
    public List<Player> findAll() {
        return playerRepository.findAll();
    }

    @Override
    public Player findOne(Long id) {
        return null;
    }
}
