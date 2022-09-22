package com.frivard.card.service;

import com.frivard.card.businessLogic.CreateGame;
import com.frivard.card.businessLogic.GameId;
import com.frivard.card.dataAccessLayer.GamePersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    private GamePersistence gamePersistence;

    @Autowired
    public GameService(GamePersistence gamePersistence) {
        this.gamePersistence = gamePersistence;
    }

    public GameId createGame() {
        return new CreateGame(gamePersistence).create();
    }
}
