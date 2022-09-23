package com.frivard.card.api;

import com.fasterxml.jackson.annotation.JsonProperty;

public class PlayerHandDto {

    private PlayerDto player;
    private int handValue;

    public PlayerHandDto(@JsonProperty("player") PlayerDto player, @JsonProperty("value") int handValue) {
        this.player = player;
        this.handValue = handValue;
    }

    public PlayerDto getPlayer() {
        return player;
    }

    public int getHandValue() {
        return handValue;
    }
}
