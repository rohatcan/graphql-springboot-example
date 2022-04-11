package com.rohat.productertask.service;

import com.rohat.productertask.dto.PlayerDto;
import com.rohat.productertask.exception.TeamLimitExceededException;
import com.rohat.productertask.model.EPosition;
import com.rohat.productertask.model.Player;
import com.rohat.productertask.repository.PlayerRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class PlayerService {

    private final PlayerRepository playerRepository;

    private static final long TEAM_SIZE = 12;


    public List<Player> getPlayers() {
        return playerRepository.findAll();
    }

    public List<Player> getPlayersByPosition(EPosition position) {
        return playerRepository.findAllByPosition(position);
    }

    public Optional<Player> getPlayer(Long id) {

        return playerRepository.findById(id);
    }

    public Player createPlayer(@Valid PlayerDto input){

        if (playerRepository.count() >= TEAM_SIZE ){
            throw new TeamLimitExceededException("Team Limit is Exceeded");
        }
        return playerRepository.save(Player.builder()
                .firstName(input.getFirstName())
                .lastName(input.getLastName())
                .position(input.getPosition())
                .build());
    }

    public Boolean deletePlayer(Long id) {
        playerRepository.deleteById(id);
        return true;
    }

    public Player save(Player player){
        return playerRepository.save(player);
    }


}
