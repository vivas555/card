package com.frivard.card.businessLogic;

import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Card card = (Card) o;
        return color == card.color && strength == card.strength;
    }

    @Override
    public int hashCode() {
        return Objects.hash(color, strength);
    }
}
