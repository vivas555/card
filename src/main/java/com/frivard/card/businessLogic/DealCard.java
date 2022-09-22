package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;
import com.frivard.card.dataAccessLayer.PlayerPersistence;

import java.util.Optional;

public class DealCard {
    private final GamePersistence gamePersistence;
    private PlayerPersistence playerPersistence;

    public DealCard(GamePersistence gamePersistence, PlayerPersistence playerPersistence) {
        this.gamePersistence = gamePersistence;
        this.playerPersistence = playerPersistence;
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
