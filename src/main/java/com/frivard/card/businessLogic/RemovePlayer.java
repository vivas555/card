package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.Game;
import com.frivard.card.businessLogic.model.GameId;
import com.frivard.card.businessLogic.model.PlayerId;
import com.frivard.card.dataAccessLayer.GamePersistence;

import java.util.Optional;

public class RemovePlayer {
    private GamePersistence persistence;

    public RemovePlayer(GamePersistence persistence) {
        this.persistence = persistence;
    }

    public void removeFromGame(GameId gameId, PlayerId playerId) {
        Game game = removePlayerFromGame(gameId, playerId);
        if (game == null)
            return;

        saveGame(game);
    }

    private Game removePlayerFromGame(GameId gameId, PlayerId playerId) {
        Game game = getGame(gameId);

        if (game == null)
            return null;

        game.removePlayer(playerId);

        return game;
    }

    private void saveGame(Game game) {
        persistence.updateGame(game);
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = persistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
