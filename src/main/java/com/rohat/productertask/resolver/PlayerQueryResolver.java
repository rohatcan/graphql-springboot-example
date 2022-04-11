package com.rohat.productertask.resolver;

import com.rohat.productertask.model.EPosition;
import com.rohat.productertask.model.Player;
import com.rohat.productertask.service.PlayerService;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Component
public class PlayerQueryResolver implements GraphQLQueryResolver {

    private final PlayerService playerService;

    public List<Player> getPlayers() {
        return playerService.getPlayers();
    }

    public List<Player> getPlayersByPosition(EPosition position) {
        return playerService.getPlayersByPosition(position);
    }

    public Optional<Player> getPlayer(Long id) {

        return playerService.getPlayer(id);
    }



}
