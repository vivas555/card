package com.frivard.card.businessLogic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GameTable {

    private Map<PlayerId, Hand> players;

    public GameTable() {
        players = new HashMap<>();
    }

    public void addPlayer(PlayerId playerId) {
        players.put(playerId, new Hand());
    }

    public void removePlayer(PlayerId playerId) {
        players.remove(playerId);
    }

    public void addCardToPlayerHand(PlayerId playerId, Card card) {
        players.get(playerId).addCard(card);

    }

    public Hand getPlayerHand(PlayerId playerId) {
        return players.get(playerId);
    }

    public List<PlayerId> getAllPlayer() {
        return new ArrayList<>(players.keySet());
    }
}
