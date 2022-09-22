package com.frivard.card.businessLogic;

public class Card {
    private final CardColor color;
    private final CardStrength strength;

    public Card(CardColor color, CardStrength strength) {
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
