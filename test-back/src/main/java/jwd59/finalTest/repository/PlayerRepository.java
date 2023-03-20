package jwd59.finalTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import jwd59.finalTest.model.Player;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
