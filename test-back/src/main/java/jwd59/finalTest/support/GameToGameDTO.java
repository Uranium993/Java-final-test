package jwd59.finalTest.support;

import jwd59.finalTest.model.Game;
import jwd59.finalTest.web.dto.GameDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GameToGameDTO implements Converter<Game, GameDTO> {


    @Override
    public GameDTO convert(Game game) {

        GameDTO dto = new GameDTO();

        dto.setId(game.getId());
        dto.setGoalsA(game.getGoalNumAAA());
        dto.setGoalsB(game.getGoalNumBBB());
        dto.setTeamNameA(game.getTeamA().getName());
        dto.setTeamNameB(game.getTeamB().getName());
        dto.setTeamAID(game.getTeamA().getId());
        dto.setTeamBID(game.getTeamB().getId());
        return dto;
    }

    public List<GameDTO> convertAll(List<Game> games){
        List<GameDTO> dtos = new ArrayList<>();

        for(Game m: games){
            dtos.add(convert(m));
        }

        return dtos;
    }
}
