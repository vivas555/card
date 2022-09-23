package com.frivard.card.businessLogic;

import com.frivard.card.businessLogic.model.Game;
import com.frivard.card.businessLogic.model.GameId;
import com.frivard.card.dataAccessLayer.GamePersistence;

import java.util.Optional;

public class AddDeck {
    private final GamePersistence gamePersistence;

    public AddDeck(GamePersistence gamePersistence) {
        this.gamePersistence = gamePersistence;
    }

    public void addDeckToGame(GameId gameId) {
        Game game = getGame(gameId);

        if (game == null) return;

        game.addDeck();

        saveGame(game);
    }

    private void saveGame(Game game) {
        gamePersistence.updateGame(game);
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = gamePersistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
