package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.Player;
import com.frivard.card.businessLogic.PlayerId;
import com.frivard.card.businessLogic.PlayerName;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class PlayerInMemoryPersistence implements PlayerPersistence {

    private static Map<PlayerId, Player> players;

    public PlayerInMemoryPersistence() {
        players = new HashMap<>();
    }

    @Override
    public PlayerId createPlayer(PlayerName playerName) {
        PlayerId playerId = generateId();
        save(playerId, new Player(playerId, playerName));

        return playerId;
    }

    @Override
    public Optional<Player> getPlayerById(PlayerId id) {
        return Optional.ofNullable(players.get(id));
    }

    private static PlayerId generateId() {
        return new PlayerId(UUID.randomUUID().toString());
    }

    private void save(PlayerId playerId, Player player) {
        players.put(playerId, player);
    }
}
