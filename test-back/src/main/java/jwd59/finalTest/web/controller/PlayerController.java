package jwd59.finalTest.web.controller;

import jwd59.finalTest.model.Player;
import jwd59.finalTest.service.PlayerService;
import jwd59.finalTest.support.PlayerToPlayerDTO;
import jwd59.finalTest.web.dto.PlayerDTO;

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
@RequestMapping(value = "/igraci", produces = MediaType.APPLICATION_JSON_VALUE)
@Validated
public class PlayerController {

    @Autowired
    private PlayerService playerService;

    @Autowired
    PlayerToPlayerDTO toPlayerDTO;

    @GetMapping
    public ResponseEntity<List<PlayerDTO>> getAll(){

        List<Player> players = playerService.findAll();

        return new ResponseEntity<>(toPlayerDTO.convertAll(players), HttpStatus.OK);
    }

}
