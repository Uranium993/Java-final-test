package jwd59.finalTest.support;

import jwd59.finalTest.model.Team;
import jwd59.finalTest.service.TeamService;
import jwd59.finalTest.web.dto.TeamDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class Model222DTOtoModel222 implements Converter<TeamDTO, Team> {

    @Autowired
    private TeamService teamService;

    @Override
    public Team convert(TeamDTO dto) {

        Team team;

        if(dto.getId() == null){
            team = new Team();
        } else {
            team = teamService.findOne(dto.getId());
        }

        return null;
    }
}
