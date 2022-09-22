package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;

public class DeleteGame {
    private GamePersistence persistence;

    public DeleteGame(GamePersistence gamePersistence) {
        persistence = gamePersistence;
    }

    public void byId(GameId gameId) {
        persistence.deleteGameById(gameId);
    }
}
