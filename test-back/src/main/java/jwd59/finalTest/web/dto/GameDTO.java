package jwd59.finalTest.web.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class GameDTO {

    private Long id;

    private String teamNameA;

    private String teamNameB;

    private int goalsA;

    private int goalsB;

    private Long teamAID;

    private Long teamBID;

}
