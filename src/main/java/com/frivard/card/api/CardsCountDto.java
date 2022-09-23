package com.frivard.card.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.frivard.card.businessLogic.CardColor;

public class CardsCountDto {
    private final int number;
    private final CardColor color;

    public CardsCountDto(int number, @JsonProperty("suit") CardColor color) {
        this.number = number;
        this.color = color;
    }

    public int getNumber() {
        return number;
    }

    public CardColor getColor() {
        return color;
    }
}
