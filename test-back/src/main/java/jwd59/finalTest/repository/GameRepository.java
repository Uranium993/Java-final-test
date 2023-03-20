package jwd59.finalTest.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd59.finalTest.model.Game;

@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

    Game findOneById(Long id);

    //Game save(Game game);

    Page<Game> findByTeamAIdAndTeamBId(Long teamAId, Long teamBId, Pageable pageable);
    Page<Game> findByTeamAId(Long teamAId, Pageable pageable);

    Page<Game> findByTeamBId(Long teamBId, Pageable pageable);

}
