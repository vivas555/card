package com.frivard.card.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frivard.card.businessLogic.CardColor;
import com.frivard.card.businessLogic.CardStrength;

public class CardDto {
    private final CardColor color;
    private final CardStrength strength;

    public CardDto(@JsonProperty("suit") CardColor color, @JsonProperty("value") CardStrength strength) {
        this.color = color;
        this.strength = strength;
    }

    public CardColor getColor() {
        return color;
    }

    public CardStrength getStrength() {
        return strength;
    }

}
