package com.frivard.card.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerDto {
    private String playerId;
    private String playerName;

    public PlayerDto(@JsonProperty("id") String playerId, @JsonProperty("name") String playerName) {
        this.playerId = playerId;
        this.playerName = playerName;
    }

    public String getPlayerId() {
        return playerId;
    }

    public String getPlayerName() {
        return playerName;
    }
}
