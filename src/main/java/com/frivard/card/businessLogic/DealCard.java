package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.Game;
import com.frivard.card.businessLogic.model.GameId;
import com.frivard.card.businessLogic.model.PlayerId;
import com.frivard.card.dataAccessLayer.GamePersistence;

import java.util.Optional;

public class DealCard {
    private final GamePersistence gamePersistence;

    public DealCard(GamePersistence gamePersistence) {
        this.gamePersistence = gamePersistence;
    }

    public void dealToPlayer(GameId gameId, PlayerId playerId) {
        Game game = getGame(gameId);

        if (game == null) return;

        game.dealCardToPlayer(playerId);

        saveGame(game);
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = gamePersistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }

    private void saveGame(Game game) {
        gamePersistence.updateGame(game);
    }
}
