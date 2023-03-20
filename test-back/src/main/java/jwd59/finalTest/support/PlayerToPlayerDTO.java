package jwd59.finalTest.support;

import jwd59.finalTest.model.Player;
import jwd59.finalTest.web.dto.PlayerDTO;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PlayerToPlayerDTO implements Converter<Player, PlayerDTO> {
    @Override
    public PlayerDTO convert(Player source) {
        PlayerDTO dto = new PlayerDTO();

        dto.setName(source.getName());
        dto.setSurname(source.getSurname());
        return dto;
    }

    public List<PlayerDTO> convertAll(List<Player> players){
        List<PlayerDTO> dtos = new ArrayList<>();
        for(Player m: players){
            dtos.add(convert(m));
        }

            return dtos;

    }

}
