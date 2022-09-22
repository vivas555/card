package com.frivard.card.businessLogic;

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

        addDeck(game);

        saveGame(game);
    }

    private void saveGame(Game game) {
        gamePersistence.saveGame(game);
    }

    private static void addDeck(Game game) {
        game.addDeck();
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = gamePersistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
