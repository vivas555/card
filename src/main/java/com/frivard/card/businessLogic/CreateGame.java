package com.frivard.card.businessLogic;

import com.frivard.card.dataAccessLayer.GamePersistence;

public class CreateGame {

    private final GamePersistence persistence;

    public CreateGame(GamePersistence persistence) {
        this.persistence = persistence;
    }

    public GameId create() {

        return persistence.createGame();
    }
}
