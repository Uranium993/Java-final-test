package jwd59.finalTest.service;

import java.util.List;

import jwd59.finalTest.model.Team;

public interface TeamService {
    Team findOne(Long id);

    List<Team> findAll();

    Team save(Team team);

    Team update(Team team);



}
