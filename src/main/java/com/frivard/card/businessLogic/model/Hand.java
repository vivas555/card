package com.frivard.card.businessLogic.model;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Hand {
    private List<Card> cards;

    public Hand() {
        cards = new LinkedList<>();
    }

    public void addCard(Card card) {
        cards.add(card);
    }

    public List<Card> getAllCards() {
        return Collections.unmodifiableList(cards);
    }

    public int getStrength() {
        int totalStrength = 0;

        for (Card card : cards) {
            totalStrength += card.getStrength().getValue();
        }

        return totalStrength;
    }
}
