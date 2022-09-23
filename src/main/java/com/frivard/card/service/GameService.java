package com.frivard.card.service;

import com.frivard.card.businessLogic.*;
import com.frivard.card.businessLogic.model.*;
import com.frivard.card.dataAccessLayer.GamePersistence;
import com.frivard.card.dataAccessLayer.PlayerPersistence;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public PlayerId addPlayer(GameId gameId, PlayerName playerName) {
        return new AddPlayer(gamePersistence, playerPersistence).addToGame(gameId, playerName);
    }

    public void removePlayer(GameId gameId, PlayerId playerId) {
        new RemovePlayer(gamePersistence).removeFromGame(gameId, playerId);
    }

    public void deal(GameId gameId, PlayerId playerId) {
        new DealCard(gamePersistence).dealToPlayer(gameId, playerId);
    }

    public Hand getHand(GameId gameId, PlayerId playerId) {
        return new GetHand(gamePersistence).getHandOfPlayer(gameId, playerId);
    }

    public List<PlayerHand> listPlayersWithHandStrength(GameId gameId) {
        return new GetPlayerHand(gamePersistence, playerPersistence).getHandWithHandStrength(gameId);
    }

    public List<Card> listCardsStillInShoe(GameId gameId) {
        return new ListCard(gamePersistence).listCardsStillInShoe(gameId);
    }

    public void shuffleShoe(GameId gameId) {
        new ShuffleShoe(gamePersistence).shuffle(gameId);
    }
}
