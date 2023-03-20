package jwd59.finalTest.support;

import jwd59.finalTest.model.Team;
import jwd59.finalTest.web.dto.TeamDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TeamToTeamDTO implements Converter<Team, TeamDTO> {


    @Override
    public TeamDTO convert(Team team) {

        TeamDTO dto = new TeamDTO();

        dto.setId(team.getId());
        dto.setName(team.getName());
        dto.setTag(team.getTag());
        return dto;

    }

    public List<TeamDTO> convertAll(List<Team> teams){
        List<TeamDTO> dtos = new ArrayList<>();
        for(Team m: teams){
            dtos.add(convert(m));
        }
        return dtos;
    }
}
