package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;

import java.util.Optional;

public class ShuffleShow {
    private GamePersistence persistence;

    public ShuffleShow(GamePersistence persistence) {
        this.persistence = persistence;
    }

    public void shuffle(GameId gameId) {
        Game game = getGame(gameId);

        if (game == null)
            return;

        game.shuffleShoe();

        saveGame(game);
    }

    private void saveGame(Game game) {
        persistence.updateGame(game);
    }

    private Game getGame(GameId gameId) {
        Optional<Game> gameOptional = persistence.getGameById(gameId);

        return gameOptional.orElse(null);

    }
}
