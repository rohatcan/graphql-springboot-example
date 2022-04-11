package com.rohat.productertask.repository;

import com.rohat.productertask.model.EPosition;
import com.rohat.productertask.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {

    List<Player> findAllByPosition(EPosition position);
}
