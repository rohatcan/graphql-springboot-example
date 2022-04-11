package com.rohat.productertask.service;

import com.rohat.productertask.dto.PlayerDto;
import com.rohat.productertask.model.EPosition;
import com.rohat.productertask.model.Player;
import com.rohat.productertask.repository.PlayerRepository;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.*;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.verify;


@ExtendWith(MockitoExtension.class)
class PlayerServiceTest {

    @Mock
    private PlayerRepository playerRepository;

    @InjectMocks
    private PlayerService playerService;

    @Captor
    private ArgumentCaptor<Player> playerCaptor;

    private Player player1;

    private Player player2;

    private Player player3;

    @BeforeEach
    void setData(){

        player1 = Player.builder()
                .id(1L)
                .firstName("Player1")
                .lastName("Test")
                .position(EPosition.C).build();


        player2 = Player.builder()
                .id(2L)
                .firstName("Player2")
                .lastName("Test")
                .position(EPosition.C).build();

        player3 = Player.builder()
                .id(3L)
                .firstName("Player3")
                .lastName("Test")
                .position(EPosition.PF).build();

    }

    @Test
    void should_return_players() {

    given(playerRepository.findAll()).willReturn(Arrays.asList(player1,player2,player3));

    List<Player> expectedResult = Arrays.asList(player1,player2,player3);
    List<Player> actualResult = playerService.getPlayers();


    assertThat(actualResult).hasSize(3);
    assertThat(actualResult.get(0)).isNotEqualTo(actualResult.get(1));
    for (Player response : actualResult) {
        assertThat(response).isIn(expectedResult);
    }

    }

    @Test
    void should_return_players_by_position() {

        given(playerRepository.findAllByPosition(EPosition.C)).willReturn(Arrays.asList(player1,player2));

        List<Player> expectedResult = Arrays.asList(player1,player2);
        List<Player> actualResult = playerService.getPlayersByPosition(EPosition.C);


        assertThat(actualResult).hasSize(2);
        assertThat(actualResult.get(0)).isNotEqualTo(actualResult.get(1));
        assertThat(actualResult.get(0).getPosition()).isEqualTo(actualResult.get(1).getPosition());
        for (Player response : actualResult) {
            assertThat(response).isIn(expectedResult);
        }
    }

    @Test
    void should_get_player() {

        given(playerRepository.findById(player1.getId())).willReturn(Optional.of(player1));

        Optional<Player> expectedResult = Optional.of(player1);
        Optional<Player> actualResult = playerService.getPlayer(player1.getId());

        assertThat(actualResult).isEqualTo(expectedResult);
    }

    @Test
    void should_create_player() {

        PlayerDto playerDto = PlayerDto.builder()
                .firstName("New")
                .lastName("Player")
                .position(EPosition.PF)
                .build();

        Player expectedResult = Player.builder()
                .firstName("New")
                .lastName("Player")
                .position(EPosition.PF)
                .build();

        Player actualResult = playerService.createPlayer(playerDto);

        verify(playerRepository).save(playerCaptor.capture());
        Player capturedValue = playerCaptor.getValue();

        assertThat(capturedValue.getFirstName()).isEqualTo(expectedResult.getFirstName());

    }

    @Test
    void should_delete_player() {

        playerService.deletePlayer(player1.getId());
        verify(playerRepository).deleteById(player1.getId());
    }

}