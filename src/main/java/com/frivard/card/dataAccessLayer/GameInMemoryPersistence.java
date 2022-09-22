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
        save(gameId, new Game(gameId));

        return gameId;
    }

    @Override
    public Optional<Game> getGameById(GameId id) {
        return Optional.ofNullable(games.get(id));
    }

    @Override
    public void deleteGameById(GameId gameId) {
        games.remove(gameId);
    }

    @Override
    public void updateGame(Game game) {
        deleteGameById(game.getId());
        save(game.getId(), game);
    }

    private void save(GameId gameId, Game game) {
        games.put(gameId, game);
    }
}
