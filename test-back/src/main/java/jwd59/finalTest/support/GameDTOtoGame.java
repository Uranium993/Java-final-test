package jwd59.finalTest.support;

import jwd59.finalTest.model.Game;
import jwd59.finalTest.service.GameService;
import jwd59.finalTest.service.TeamService;
import jwd59.finalTest.web.dto.GameDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class GameDTOtoGame implements Converter<GameDTO, Game> {

    @Autowired
    private GameService gameService;

    @Autowired
    private TeamService teamService;

    @Override
    public Game convert(GameDTO dto) {

        Game game;


        if(dto.getId() == null){
            game = new Game();
        }else {
            game = gameService.findById(dto.getId());
        }

        game.setTeamA(teamService.findOne(dto.getTeamAID()));
        game.setTeamB(teamService.findOne(dto.getTeamBID()));
        game.setGoalNumAAA(0);
        game.setGoalNumBBB(0);

        return game;
    }
}
