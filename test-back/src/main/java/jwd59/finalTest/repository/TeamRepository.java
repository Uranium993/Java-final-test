package jwd59.finalTest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jwd59.finalTest.model.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {

    Team findOneById(Long id);
}
