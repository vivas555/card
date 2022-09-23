package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.Game;
import com.frivard.card.businessLogic.model.GameId;
import com.frivard.card.businessLogic.model.Hand;
import com.frivard.card.businessLogic.model.PlayerId;
import com.frivard.card.dataAccessLayer.GamePersistence;

import java.util.Optional;

public class GetHand {
    private GamePersistence gamePersistence;

    public GetHand(GamePersistence gamePersistence) {
        this.gamePersistence = gamePersistence;
    }

    public Hand getHandOfPlayer(GameId gameId, PlayerId playerId) {

        Game game = getGame(gameId);

        if (game == null) return null;

        return game.getPlayerHand(playerId);

    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = gamePersistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
