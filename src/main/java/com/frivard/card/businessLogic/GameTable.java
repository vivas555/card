package com.frivard.card.businessLogic;

import java.util.HashMap;
import java.util.Map;

public class GameTable {

    private static Map<PlayerId, Hand> players;

    public GameTable() {
        players = new HashMap<>();
    }

    public void addPlayer(Player player) {
        players.put(player.getId(), new Hand());
    }

    public void removePlayer(PlayerId playerId) {
        players.remove(playerId);
    }
}
