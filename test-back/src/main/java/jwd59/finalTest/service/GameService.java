package jwd59.finalTest.service;


import org.springframework.data.domain.Page;

import jwd59.finalTest.model.Game;

import java.util.List;
import java.util.Optional;

public interface GameService {
    Optional<Game> findOne(Long id);

    Game findById(Long id);

    List<Game> findAll();

    Game save(Game game);

    Game update(Game game);

    Game updateGoals(Long id, String teamId);

    Game delete(Long id);

    Page<Game> search(Long teamAId, Long teamBId, int page);
}
