package com.frivard.card.businessLogic;

import java.util.HashMap;
import java.util.Map;

public class GameTable {

    private static Map<PlayerId, Player> players;

    public GameTable() {
        players = new HashMap<>();
    }

    public void addPlayer(Player player) {
        players.put(player.getId(), player);
    }
    
}
