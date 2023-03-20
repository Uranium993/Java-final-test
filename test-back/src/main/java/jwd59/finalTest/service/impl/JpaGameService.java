package jwd59.finalTest.service.impl;

import jwd59.finalTest.model.Game;
import jwd59.finalTest.repository.GameRepository;
import jwd59.finalTest.service.GameService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Optional;

@Service
public class JpaGameService implements GameService {

    @Autowired
    private GameRepository gameRepository;


    @Override
    public Optional<Game> findOne(Long id) {
        return Optional.empty();
    }

    @Override
    public Game findById(Long id) {
        return  gameRepository.findOneById(id);
    }

    @Override
    public List<Game> findAll() {
        return gameRepository.findAll();
    }

    @Override
    public Game save(Game game) {
        return gameRepository.save(game);
    }

    @Override
    public Game update(Game game) {
        return null;
    }

    @Override
    public Game updateGoals(Long id, String teamId) {

        Game game = gameRepository.findOneById(id);
        if(teamId.equals("A")){
            game.setGoalNumAAA(game.getGoalNumAAA() + 1) ;
        } else {
            game.setGoalNumBBB(game.getGoalNumBBB() + 1);
        }
        gameRepository.save(game);
        return game;
    }


    @Override
    public Game delete(Long id) {
        Optional<Game> model1 = gameRepository.findById(id);
        if(model1.isPresent()){
            gameRepository.deleteById(id);
            return model1.get();
        }
        return null;

    }

    @Override
    public Page<Game> search(Long teamAId, Long teamBId, int page) {
        if(teamAId == null && teamBId == null){
            return gameRepository.findAll(PageRequest.of(page, 3));
        }
        if(teamAId != null && teamBId == null){
            return gameRepository.findByTeamAId(teamAId, PageRequest.of(page, 3));
        }

            if(teamBId != null && teamAId == null){
            return gameRepository.findByTeamBId(teamBId, PageRequest.of(page, 3));
            }

        return gameRepository.findByTeamAIdAndTeamBId(teamAId, teamBId, PageRequest.of(page, 3));
    }

    private LocalDateTime getDateConverted(String dateTime) throws DateTimeParseException {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        return LocalDateTime.parse(dateTime, formatter);
    }
}
