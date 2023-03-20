package jwd59.finalTest.web.controller;

import jwd59.finalTest.model.Team;
import jwd59.finalTest.service.TeamService;
import jwd59.finalTest.support.TeamToTeamDTO;
import jwd59.finalTest.web.dto.TeamDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/reprezentacije", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class TeamController {

    @Autowired
    private TeamService teamService;

    @Autowired
    TeamToTeamDTO toTeamDTO;

    @GetMapping
    public ResponseEntity<List<TeamDTO>> getAll(){

        List<Team> teams = teamService.findAll();

        return new ResponseEntity<>(toTeamDTO.convertAll(teams), HttpStatus.OK);
    }
}
