package jwd59.finalTest.web.controller;

import jwd59.finalTest.support.GameDTOtoGame;
import jwd59.finalTest.support.GameToGameDTO;
import jwd59.finalTest.model.Game;
import jwd59.finalTest.service.GameService;
import jwd59.finalTest.web.dto.GameDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;

@RestController
@RequestMapping(value = "/api/utakmice", produces = MediaType.APPLICATION_JSON_VALUE)
public class GameController {

    @Autowired
    private GameService gameService;

    @Autowired
    private GameToGameDTO toGameDTO;

    @Autowired
    private GameDTOtoGame toGame;

    @GetMapping
    public ResponseEntity<List<GameDTO>>getAll(@RequestParam(required = false) Long teamAId,
                                               @RequestParam(required = false) Long teamBId,
                                               @RequestParam(name = "pageNo", defaultValue = "0") Integer page){

        Page<Game> gamePage = gameService.search(teamAId, teamBId, page);


        return new ResponseEntity<>(toGameDTO.convertAll(gamePage.getContent()), HttpStatus.OK);
    }

    @GetMapping(value = "/{id}", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameDTO> getOne(@PathVariable Long id){
        Game game = gameService.findById(id);
        if(game != null){
            return new ResponseEntity<>(toGameDTO.convert(game), HttpStatus.OK);

        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<GameDTO> create(@RequestBody GameDTO gameDTO){


        gameService.save(toGame.convert(gameDTO));
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @PutMapping(value = "/{id}/{teamID}")
    public ResponseEntity<GameDTO> update(@PathVariable Long id, @PathVariable String teamID){
//        if(id.equals(gameDTO.getId())){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }
//        if(id == null || teamID == null){
//            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
//        }

        gameService.updateGoals(id, teamID);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        Game deleted = gameService.delete(id);

        if(deleted != null) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    private LocalDateTime getLocalDateTime(String datumIVreme) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate datum = LocalDate.parse(datumIVreme.substring(0, 10), formatter);
        LocalTime vreme = LocalTime.parse(datumIVreme.substring(11), DateTimeFormatter.ofPattern("HH:mm"));
        return LocalDateTime.of(datum, vreme);
    }
}
