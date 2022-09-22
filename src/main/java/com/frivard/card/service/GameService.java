package com.frivard.card.service;

import com.frivard.card.businessLogic.*;
import com.frivard.card.dataAccessLayer.GamePersistence;
import com.frivard.card.dataAccessLayer.PlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//TODO Separate Injection from assembling concerns.
public class GameService {

    private GamePersistence gamePersistence;
    private PlayerPersistence playerPersistence;

    @Autowired
    public GameService(GamePersistence gamePersistence, PlayerPersistence playerPersistence) {
        this.gamePersistence = gamePersistence;
        this.playerPersistence = playerPersistence;
    }

    public GameId createGame() {
        return new CreateGame(gamePersistence).create();
    }

    public void deleteGameById(GameId gameId) {
        new DeleteGame(gamePersistence).byId(gameId);
    }

    public void addDeck(GameId gameId) {
        new AddDeck(gamePersistence).addDeckToGame(gameId);
    }

    public void addPlayer(GameId gameId, PlayerName playerName) {
        new AddPlayer(gamePersistence, playerPersistence).add(gameId, playerName);
    }

    public void removePlayer(GameId gameId, PlayerId playerId) {
        new RemovePlayer(gamePersistence).remove(gameId, playerId);
    }
}
