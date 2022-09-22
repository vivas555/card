package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import com.frivard.card.dataAccessLayer.PlayerPersistence;

import java.util.Optional;

public class AddPlayer {
    private final GamePersistence gamePersistence;
    private final PlayerPersistence playerPersistence;

    public AddPlayer(GamePersistence gamePersistence, PlayerPersistence playerPersistence) {
        this.gamePersistence = gamePersistence;
        this.playerPersistence = playerPersistence;
    }

    public PlayerId addToGame(GameId gameId, PlayerName playerName) {
        PlayerId playerId = createPlayer(playerName);

        Game game = addPlayerToGame(gameId, playerId);

        if (game == null)
            return playerId;

        saveGame(game);

        return playerId;
    }

    private PlayerId createPlayer(PlayerName playerName) {
        return playerPersistence.createPlayer(playerName);
    }

    private Game addPlayerToGame(GameId gameId, PlayerId playerId) {
        Game game = getGame(gameId);

        if (game == null)
            return null;

        game.addPlayer(playerId);

        return game;
    }

    private void saveGame(Game game) {
        gamePersistence.updateGame(game);
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = gamePersistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
