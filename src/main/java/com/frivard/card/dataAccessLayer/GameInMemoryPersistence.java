package com.frivard.card.dataAccessLayer;

import com.frivard.card.businessLogic.Game;
import com.frivard.card.businessLogic.GameId;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
public class GameInMemoryPersistence implements GamePersistence {

    private static Map<GameId, Game> games;

    public GameInMemoryPersistence() {
        games = new HashMap<>();
    }

    @Override
    public GameId createGame() {
        GameId gameId = new GameId(UUID.randomUUID().toString());
        games.put(gameId, new Game(gameId));

        return gameId;
    }

    @Override
    public Optional<Game> getGameById(GameId id) {
        return Optional.ofNullable(games.get(id));
    }
}
