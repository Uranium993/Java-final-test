package jwd59.finalTest.service.impl;

import jwd59.finalTest.model.Team;
import jwd59.finalTest.repository.TeamRepository;
import jwd59.finalTest.service.TeamService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JpaTeamService implements TeamService {

    @Autowired
    private TeamRepository teamRepository;

    @Override
    public Team findOne(Long id) {
        return teamRepository.findOneById(id);
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team save(Team team) {
        return null;
    }

    @Override
    public Team update(Team team) {
        return null;
    }
}
