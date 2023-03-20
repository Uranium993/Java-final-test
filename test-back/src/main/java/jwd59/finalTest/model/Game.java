package jwd59.finalTest.model;



import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@ToString
@Entity
public class Game {
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @ManyToOne
    private Team teamA;

    @ManyToOne
    private Team teamB;

    @Column
    private int goalNumAAA;

    @Column
    private int goalNumBBB;
}
