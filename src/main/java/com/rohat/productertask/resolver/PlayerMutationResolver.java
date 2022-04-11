package com.rohat.productertask.resolver;

import com.rohat.productertask.dto.PlayerDto;
import com.rohat.productertask.model.Player;
import com.rohat.productertask.service.PlayerService;
import graphql.kickstart.tools.GraphQLMutationResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.Valid;

@AllArgsConstructor
@Component
public class PlayerMutationResolver implements GraphQLMutationResolver {

    private final PlayerService playerService;

    public Player createPlayer(@Valid PlayerDto input){

        return playerService.createPlayer(input);
    }

    public Boolean deletePlayer(Long id) {
         return playerService.deletePlayer(id);
    }
}
