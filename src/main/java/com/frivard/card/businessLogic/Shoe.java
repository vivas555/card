package com.frivard.card.businessLogic;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;

public class Shoe {
    private List<Card> cards;

    public Shoe() {
        cards = new LinkedList<>();
    }

    public void addDeck() {
        for (CardColor color : CardColor.values()) {
            for (CardStrength strength : CardStrength.values()) {
                cards.add(new Card(color, strength));
            }
        }
    }

    public Optional<Card> draw() {
        if (cards.isEmpty())
            return Optional.empty();

        return Optional.ofNullable(cards.remove(0));
    }
}
