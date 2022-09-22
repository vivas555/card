package com.frivard.card.api;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class HandDto {
    private List<CardDto> cards;

    public HandDto(@JsonProperty("cards") List<CardDto> cards) {
        this.cards = cards;
    }

    public List<CardDto> getCards() {
        return cards;
    }
}
